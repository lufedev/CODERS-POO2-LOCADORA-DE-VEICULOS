package br.com.ada.grupo3.locadora.model;

public class Agencia implements Entidade {

    private final String nome;
    private final String logradouro;

    public Agencia(String nome, String logradouro) {
        this.nome = nome;
        this.logradouro = logradouro;
    }

    public String getId() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nome='" + nome + '\'' +
                ", logradouro='" + logradouro + '\'' +
                '}';
    }
}
