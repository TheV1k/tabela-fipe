package br.com.projetos.tabela_fipe.service;

import java.text.Normalizer;

public class RemoveAcentos {

    public static String removeAcentos (String texto){

        String veiculoSemAcento = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return veiculoSemAcento.replaceAll("[^\\p{ASCII}]", "");
    }
}