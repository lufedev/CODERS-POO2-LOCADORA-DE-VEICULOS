package br.com.ada.projeto.locadoraveiculos.model;

public class Agencia implements Entidade {

    private String nome;
    private String logradouro;

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
