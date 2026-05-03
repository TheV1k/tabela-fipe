package br.com.projetos.tabela_fipe.service;

import java.util.List;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);

    public <T> List<T> obterLista(String json, Class<T> classe);
}
