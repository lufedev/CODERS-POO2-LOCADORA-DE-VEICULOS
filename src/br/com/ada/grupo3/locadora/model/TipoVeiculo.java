package br.com.ada.grupo3.locadora.model;

import java.math.BigDecimal;

public class TipoVeiculo implements Entidade {

    private final String descricao;
    private final BigDecimal tarifa;

    public TipoVeiculo(String descricao, BigDecimal tarifa) {
        this.descricao = descricao;
        this.tarifa = tarifa;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getId() {
        return descricao;
    }

    @Override
    public String toString() {
        return "TipoVeiculo{" +
                "descricao='" + descricao + '\'' +
                ", tarifa=" + tarifa +
                '}';
    }

    public String getTarifa() {
        return tarifa.toString();
    }

    public String getString() {
        return descricao + "$" + tarifa;
    }
}
