package br.com.projetos.tabela_fipe.principal;
import br.com.projetos.tabela_fipe.model.*;
import br.com.projetos.tabela_fipe.service.ConsumoApi;
import br.com.projetos.tabela_fipe.service.ConverteDados;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {

        System.out.println("Digite o tipo de veiculo (Carros/Motos/Caminhões)");
        var tipoVeiculo = sc.nextLine().toLowerCase().trim();
        var json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas/");
        List<DadosVeiculo> veiculos = conversor.obterLista(json, DadosVeiculo.class);
        veiculos.forEach(v -> System.out.printf("Cód: %s | Marca: %s\n", v.codigo(), v.marca()));
       Modelos resposta = null;
       String codMarca = null;
        while (true)
            try {
                System.out.println("Digite o código da marca");
                codMarca = sc.nextLine();
                json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas/" + codMarca + "/modelos/");
                resposta = conversor.obterDados(json, Modelos.class);
                resposta.modelos().forEach(m ->
                        System.out.printf("Cód: %s | Marca: %s\n", m.cod(), m.descricao()));
                break;
            } catch (NullPointerException e) {
                System.out.println("Código inválido. Digite um código válido.");
            }

        System.out.println("Digite parte do nome do modelo desejado: ");
        var pesquisaModelo = sc.nextLine().toLowerCase().trim();
        List<DadosMarca> modelosFiltrados = resposta.modelos()
                .stream()
                .filter(n -> n.descricao().toLowerCase().contains(pesquisaModelo))
                .toList();
        if (modelosFiltrados.isEmpty()) {
            System.out.println("Nenhum modelo encontrado");
        } else {
            modelosFiltrados.forEach(
                    p ->System.out.printf("Cód: %s | Marca: %s\n", p.cod(), p.descricao()));

        }

        System.out.println("Digite o código do modelo:");
        var codModelo = sc.nextLine();
        json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/");
        List<DadosAnos> organizaAnos = conversor.obterLista(json, DadosAnos.class);

        for (int i = 0; i < organizaAnos.size() ; i++) {

            var anoVeiculo = organizaAnos.get(i);
            json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/" + anoVeiculo);
            Veiculo informacoesVeiculo = conversor.obterDados(json, Veiculo.class);
            System.out.println(informacoesVeiculo);
        }




    }
}

