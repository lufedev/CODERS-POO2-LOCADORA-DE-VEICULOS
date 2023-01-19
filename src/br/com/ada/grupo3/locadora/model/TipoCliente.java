package br.com.ada.grupo3.locadora.model;

import java.math.BigDecimal;

public class TipoCliente {

    private String descricao;
    private BigDecimal desconto;
    private int quantidadeDiasParaDesconto;

    public TipoCliente(String descricao, BigDecimal desconto, int quantidadeDiasParaDesconto) {
        this.descricao = descricao;
        this.desconto = desconto;
        this.quantidadeDiasParaDesconto = quantidadeDiasParaDesconto;
    }


}