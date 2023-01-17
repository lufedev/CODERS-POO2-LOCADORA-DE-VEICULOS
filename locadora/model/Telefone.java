package br.com.ada.grupo3.locadora.model;

import java.util.Objects;

public class Telefone {


    public String ddi;
    public String ddd;
    public String numero;

    private Telefone() {

    }//LEITURA JACKSON

    public Telefone(String ddi, String ddd, String numero) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String numeroImpressaoReduzida() {
        return String.format( ddi + "(" + ddd + ")" + numero);
    }

    @Override
    public String toString() {
        return String.format(
                        "DDI: %s \n" +
                        "DDD: %s \n" +
                        "Número: %s \n", ddi, ddd, numero);
    }

    @Override
    public boolean equals(Object o) { //DEFINIR O QUE QUALIFICA A IGUALDADE.
        if (this == o) return true;
        if (!(o instanceof Telefone telefone)) return false;
        return ddi.equals(telefone.ddi) && ddd.equals(telefone.ddd) && numero.equals(telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddi, ddd, numero);
    }
}
