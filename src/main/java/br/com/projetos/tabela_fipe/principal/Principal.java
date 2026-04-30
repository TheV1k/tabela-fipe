package br.com.projetos.tabela_fipe.principal;

import br.com.projetos.tabela_fipe.model.DadosVeiculo;
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

    public void exibeMenu (){
        System.out.println("Digite o tipo de veiculo (Carros/Motos/Caminhões)");
        var tipoVeiculo = sc.nextLine().toLowerCase().trim();

        List<DadosVeiculo> veiculos = new ArrayList<>();

        var json = consumo.obterDados(ENDERECO +tipoVeiculo +"/marcas");
        DadosVeiculo dados = conversor.obterDados(json, DadosVeiculo.class);
        System.out.println(dados);
    }
}
