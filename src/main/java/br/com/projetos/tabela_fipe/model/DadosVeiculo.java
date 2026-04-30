package br.com.projetos.tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo (
        @JsonAlias("nome") String marca,
       @JsonAlias("codigo") String codigo
) {
}
