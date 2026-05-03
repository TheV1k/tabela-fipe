package br.com.projetos.tabela_fipe.principal;
import br.com.projetos.tabela_fipe.model.*;
import br.com.projetos.tabela_fipe.service.ConsumoApi;
import br.com.projetos.tabela_fipe.service.ConverteDados;
import tools.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.projetos.tabela_fipe.service.RemoveAcentos.removeAcentos;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    ObjectMapper mapper = new ObjectMapper();
    List<Veiculo> arquivoVeiculos = new ArrayList<>();
    String pesquisaVeiculo = null;

    public void exibeMenu() {
        var json = consumo.obterDados(ENDERECO);
        String tipoVeiculo = null;

        while (true){
            try{
                System.out.println("Digite o tipo de veiculo (Carros/Motos/Caminhões)");
               tipoVeiculo = sc.nextLine().toLowerCase().trim();
                pesquisaVeiculo = removeAcentos(tipoVeiculo);
                json = consumo.obterDados(ENDERECO + pesquisaVeiculo + "/marcas/");
                List<DadosVeiculo> veiculos = null;
                veiculos = conversor.obterLista(json, DadosVeiculo.class);
                veiculos.forEach(v -> System.out.printf("Cód: %s | Marca: %s\n", v.codigo(), v.marca()));
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Veículo inválido");
            } catch (RuntimeException e){
                System.out.println("Erro ao consumir a API: " + e.getMessage());
            }
        }

       Modelos resposta = null;
       String codMarca = null;

       while (true) {
           System.out.println("Digite o código da marca");
           codMarca = sc.nextLine().trim();
           json = consumo.obterDados(ENDERECO + pesquisaVeiculo + "/marcas/" + codMarca + "/modelos/");
           resposta = conversor.obterDados(json, Modelos.class);
           if (resposta == null || resposta.modelos() == null || resposta.modelos().isEmpty()) {
               System.out.println("Código inválido. Digite um código válido.");
               continue;
           }
           resposta.modelos().forEach(m ->
                   System.out.printf("Cód: %s | Marca: %s\n", m.codigo(), m.nome()));
           break;

       }

        while (true) {
            System.out.println("Digite parte do nome do modelo desejado: ");

        var pesquisaModelo = sc.nextLine().toLowerCase().trim();
        List<DadosMarca> modelosFiltrados = resposta.modelos()
                .stream()
                .filter(n -> n.nome().toLowerCase().contains(pesquisaModelo))
                .toList();

        if (modelosFiltrados.isEmpty()) {

            System.out.println("Nenhum modelo encontrado. Digite um modelo válido");
            continue;
        }
            modelosFiltrados.forEach(
                    p ->System.out.printf("Cód: %s | Marca: %s\n", p.codigo(), p.nome()));
        break;

        }

        System.out.println("Digite o código do modelo:");
        var codModelo = sc.nextLine().trim();
        if (codModelo.isBlank()){
            System.out.println("Código inválido.");
            return;
        }
        json = consumo.obterDados(ENDERECO + pesquisaVeiculo + "/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/");
        List<DadosAnos> organizaAnos = conversor.obterLista(json, DadosAnos.class);
        if (organizaAnos == null || organizaAnos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado.");
            return;
        }
        for (int i = 0; i < organizaAnos.size() ; i++) {
            var anoVeiculo = organizaAnos.get(i);
            json = consumo.obterDados(ENDERECO + pesquisaVeiculo + "/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/" + anoVeiculo.codigo());
            Veiculo informacoesVeiculo = conversor.obterDados(json, Veiculo.class);
            if (informacoesVeiculo != null){
                arquivoVeiculos.add(informacoesVeiculo);
                System.out.println(informacoesVeiculo);
            }

            }

            mapper.writeValue(new File("dados_tabela_fipe.json"), arquivoVeiculos);
        }

    }



