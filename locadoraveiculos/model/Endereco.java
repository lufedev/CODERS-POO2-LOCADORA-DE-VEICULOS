package br.com.ada.projeto.locadoraveiculos.model;

import java.util.Objects;

public class Endereco {

    //    private TipoEndereco tipo;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    private Endereco(){

    }//LEITURA JACKSON

    public Endereco(/*TipoEndereco tipo,*/ String logradouro, String bairro, String numero, String complemento, String cep, String cidade, String uf) {
//        this.tipo = tipo;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

//    public TipoEndereco getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(TipoEndereco tipo) {
//        this.tipo = tipo;
//    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    @Override
    public String toString() {
        return String.format(
                "Tipo: %s \n" +
                        "Logradouro: %s \n" +
                        "Bairro: %s \n" +
                        "Numero: %s \n" +
                        "CEP: %s \n" +
                        "Complemento: %s \n" +
                        "Cidade: %s \n" +
                        "UF: %s \n",/* tipo,*/ logradouro, bairro, numero, cep, complemento, cidade, uf);
    }

    @Override
    public boolean equals(Object o) { //DEFINIR O QUE QUALIFICA A IGUALDADE
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return logradouro.equalsIgnoreCase(endereco.logradouro) && bairro.equalsIgnoreCase(endereco.bairro) &&
                cep.equalsIgnoreCase(endereco.cep) && numero.equalsIgnoreCase(endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, bairro, cep, numero);
    }
}
