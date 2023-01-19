package br.com.ada.grupo3.locadora.model;

public class Agencia implements Entidade {

    private final String nome;
    private final String endereco;

    public Agencia(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getId() {
        return nome;
    }

    public String getLogradouro() {
        return endereco;
    }


    public String getNome() {
        return nome;
    }
}
