package br.com.ada.projeto.locadoraveiculos.model;

public class Veiculo implements Entidade {

    private String placa;
    private String modelo;
    private String fabricante;

    private boolean disponível;
    private TipoVeiculo tipo;

    public Veiculo(String placa, String modelo, String fabricante, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.disponível = true;
    }


    @Override
    public String getId() {
        return placa;
    }
}
