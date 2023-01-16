package br.com.ada.projeto.locadoraveiculos.model;

import java.math.BigDecimal;

public class TipoVeiculo {

    private String descricao;

    private BigDecimal tarifa;

    public TipoVeiculo(String descricao, BigDecimal tarifa) {
        this.descricao = descricao;
        this.tarifa = tarifa;
    }

}
