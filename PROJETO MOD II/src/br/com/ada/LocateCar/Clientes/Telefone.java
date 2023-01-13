package br.com.ada.LocateCar.Clientes;

import java.util.Objects;

public class Telefone {

    //    public TipoTelefone tipo;
    public String ddi;
    public String ddd;
    public String numero;

    private Telefone() {

    }//LEITURA JACKSON

    public Telefone(/*TipoTelefone tipo,*/ String ddi, String ddd, String numero) {
//        this.tipo = tipo;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

//    public TipoTelefone getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(TipoTelefone tipo) {
//        this.tipo = tipo;
//    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String numeroImpressaoReduzida() {
        return String.format(/*tipo + " " +*/ ddi + "(" + ddd + ")" + numero);
    }

    @Override
    public String toString() {
        return String.format(
                "Tipo: %s \n" +
                        "DDI: %s \n" +
                        "DDD: %s \n" +
                        "Número: %s \n",/* tipo,*/ ddi, ddd, numero);
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
