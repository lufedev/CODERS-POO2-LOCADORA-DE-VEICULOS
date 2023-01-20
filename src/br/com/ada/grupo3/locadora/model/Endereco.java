package br.com.ada.grupo3.locadora.model;

import java.util.Objects;

public class Endereco {

    private final String logradouro;
    private final Integer numero;
    private final String cidade;
    private final String uf;

    public Endereco(String logradouro, Integer numero, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return String.format("""
                        Logradouro: %s
                        Numero: %s
                        Cidade: %s
                        UF: %s
                        """, logradouro, numero, cidade, uf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return logradouro.equalsIgnoreCase(endereco.logradouro) && numero.equals(endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero.toString();
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.logradouro);
        sb.append("$");
        sb.append(this.numero);
        sb.append("$");
        sb.append(this.cidade);
        sb.append("$");
        sb.append(this.uf);
        return sb.toString();
    }
}
