package br.com.projetos.tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Veiculo {

    String valor;
    String marca;
    String modelo;
    String ano;
    String combustivel;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Veiculo(@JsonAlias("Valor") String valor,
                   @JsonAlias("Marca") String marca,
                   @JsonAlias("Modelo")String modelo,
                   @JsonAlias("AnoModelo")String ano,
                   @JsonAlias("Combustivel") String combustivel) {
         this.valor = valor;
         this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "valor=" + valor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", combustivel='" + combustivel + '\'' +
                '}';
    }
}
