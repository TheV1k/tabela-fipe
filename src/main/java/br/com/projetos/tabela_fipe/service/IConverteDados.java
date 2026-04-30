package br.com.projetos.tabela_fipe.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
