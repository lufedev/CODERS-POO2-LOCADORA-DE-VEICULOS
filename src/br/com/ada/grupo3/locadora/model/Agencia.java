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
        return String.format("""
                        Agencia
                        Nome: %s
                        Logradouro: %s
                        Numero: %s
                        Cidade: %s
                        UF: %s
                        """, nome, endereco.getLogradouro(), endereco.getNumero(), endereco.getCidade(),endereco.getUf());
    }

    public String getNome() {
        return nome;
    }
}
