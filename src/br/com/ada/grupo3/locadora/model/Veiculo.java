package br.com.ada.grupo3.locadora.model;

import java.util.Collection;

public class Veiculo implements Entidade {

    private String placa;
    private String modelo;
    private String fabricante;
    private boolean disponivel;
    private TipoVeiculo tipo;

    public Veiculo(String placa, String modelo, String fabricante, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.disponivel = true;
    }

    @Override
    public String getId() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return """
                %s
                placa => %s
                modelo => %s
                fabricante => %s
                disponível=> %s
                """.formatted(tipo.getDescricao(), placa, modelo, fabricante, disponivel);
    }
}
