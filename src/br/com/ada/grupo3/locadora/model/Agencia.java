package br.com.ada.grupo3.locadora.model;

public class Agencia implements Entidade {

    private final String nome;
    private final Endereco endereco;

    public Agencia(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getId() {
        return nome;
    }

    public String getLogradouro() {
        return endereco.getLogradouro();
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nome='" + nome + '\'' +
                ", logradouro='" + endereco.getLogradouro() + '\'' +
                ", numero ='" + endereco.getNumero() + '\'' +
                ", cidade ='" + endereco.getCidade() + '\'' +
                ", uf ='" + endereco.getUf() + '\'' +
                '}';
    }
}
