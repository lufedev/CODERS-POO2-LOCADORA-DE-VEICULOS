package br.com.ada.projeto.locadoraveiculos.model;

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

    @Override
    public String toString() {
        return "TipoCliente{" +
                "descricao='" + descricao + '\'' +
                ", desconto=" + desconto +
                ", quantidadeDiasParaDesconto=" + quantidadeDiasParaDesconto +
                '}';
    }
}