package br.com.projetos.tabela_fipe.principal;
import br.com.projetos.tabela_fipe.model.DadosMarca;
import br.com.projetos.tabela_fipe.model.DadosVeiculo;
import br.com.projetos.tabela_fipe.model.Modelos;
import br.com.projetos.tabela_fipe.service.ConsumoApi;
import br.com.projetos.tabela_fipe.service.ConverteDados;

import java.util.ArrayList;
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

        while (true)
            try {
                System.out.println("Digite o código da marca");
                var codMarca = sc.nextLine();
                json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas/" + codMarca + "/modelos/");
                var resposta = conversor.obterDados(json, Modelos.class);

                resposta.modelos().forEach(m ->
                        System.out.printf("Cód: %s | Marca: %s\n", m.cod(), m.descricao()));
            } catch (NullPointerException e) {

                System.out.println("Código inválido. Digite um código válido.");

            }

    }
}

