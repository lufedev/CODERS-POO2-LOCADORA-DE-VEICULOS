package br.com.ada.grupo3.locadora.model;

import java.util.Objects;

public class Endereco {

    private String logradouro;

    private String cep;
    private String numero;

    private String cidade;


    private Endereco(){

    }//LEITURA JACKSON

    public Endereco( String logradouro , String numero, String cep, String cidade ) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;

    }



    @Override
    public String toString() {
        return String.format(
                        "Logradouro: %s \n" +
                        "Numero: %s \n" +
                        "CEP: %s \n" +
                        "Cidade: %s \n",logradouro, numero, cep, cidade);
    }

    @Override
    public boolean equals(Object o) { //DEFINIR O QUE QUALIFICA A IGUALDADE
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;
        return logradouro.equalsIgnoreCase(endereco.logradouro) &&
                cep.equalsIgnoreCase(endereco.cep) && numero.equalsIgnoreCase(endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, cep, numero);
    }
}
