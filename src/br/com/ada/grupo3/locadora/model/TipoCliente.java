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

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "TipoCliente{" +
                "descricao='" + descricao + '\'' +
                ", desconto=" + desconto +
                ", quantidadeDiasParaDesconto=" + quantidadeDiasParaDesconto +
                '}';
    }

    public String rawString(){
        return descricao;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.descricao);
        sb.append("$");
        sb.append(this.desconto);
        sb.append("$");
        sb.append(this.quantidadeDiasParaDesconto);
        return sb.toString();
    }
}