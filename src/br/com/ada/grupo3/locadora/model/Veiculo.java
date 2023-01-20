package br.com.ada.grupo3.locadora.model;

public class Veiculo implements Entidade {

    private final String placa;
    private final String modelo;
    private final String fabricante;
    private boolean disponivel;
    private final TipoVeiculo tipo;

    public Veiculo(String placa, String modelo, String fabricante, TipoVeiculo tipo) {
        this.placa = placa.toLowerCase();
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
                  tarifa => %s
                  disponível=> %s
                """.formatted(tipo.getDescricao(), placa, modelo, fabricante,tipo.getTarifa(), disponivel);
    }

    public String getPlaca() {
        return placa;
    }

    public Boolean getDisponivel(){
        return disponivel;
    }

    public void alugarCarro(){
        this.disponivel = false;
    }

    public void devolverCarro(){
        this.disponivel = true;
    }
}
