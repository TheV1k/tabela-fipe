package br.com.projetos.tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarca(@JsonAlias("codigo") String cod,
                         @JsonAlias("nome") String descricao) {
}
