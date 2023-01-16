public class veiculo {
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private double valorDiaria;
    private boolean disponivel;

    public veiculo() {
    }

    public veiculo(String marca, String modelo, String cor, String placa, double valorDiaria, boolean disponivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    // Getters and setters for all fields
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}