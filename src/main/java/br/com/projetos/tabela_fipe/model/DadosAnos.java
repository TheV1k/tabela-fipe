package br.com.projetos.tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAnos(@JsonAlias("codigo") String codigo) {

    @Override
    public String toString() {
        return codigo;
    }
}
