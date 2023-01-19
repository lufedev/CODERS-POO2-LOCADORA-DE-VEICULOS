package br.com.ada.grupo3.locadora.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

public class Aluguel implements Entidade {
    private boolean emAberto;
    private UUID id;

    private Cliente cliente;
    private Cliente motorista;
    private Veiculo veiculo;
    private Agencia agenciaRetirada;
    private Agencia agenciaDevolucao;
    private LocalDateTime dataRetirada;
    private Integer diasAlugados;
    private LocalDateTime dataDevolucaoPrevista;
    private BigDecimal valorAluguel;
    private BigDecimal valorPrevisto;

    public Aluguel(Cliente cliente,Cliente motorista, Veiculo veiculo, Agencia agenciaRetirada, Agencia agenciaDevolucao, LocalDateTime dataRetirada, Integer diasAlugados) {
        this.emAberto = true;
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.agenciaRetirada = agenciaRetirada;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataRetirada = dataRetirada;
        this.diasAlugados = diasAlugados;
        this.dataDevolucaoPrevista = dataRetirada.plus(diasAlugados, ChronoUnit.DAYS);
        this.valorAluguel = null;
    }

    public String getId() {
        return id.toString();
    }

    public String calcularPreco(){

        TipoVeiculo tV = this.veiculo.getTipo();
        switch(tV.getDescricao()){
            case ("Carro"):
                this.valorPrevisto  =BigDecimal.valueOf(150L * diasAlugados);
                System.out.println("Valor total R$" + this.valorPrevisto );
                break;
            case ("Moto"):
                this.valorPrevisto  =BigDecimal.valueOf( 100L * diasAlugados);
                System.out.println("Valor total R$" + this.valorPrevisto );
                break;
            case ("Caminhão"):
                this.valorPrevisto  = BigDecimal.valueOf(200L * diasAlugados);
                System.out.println("Valor total R$" + this.valorPrevisto );
                break;

        }
        if (this.cliente.getTipoRaw().equals("Pessoa Fisica") && this.diasAlugados > 5) {
            return ("Valor previsto: R$ " + ((this.valorPrevisto.subtract(this.valorPrevisto.multiply(BigDecimal.valueOf(0.05))))+ "Desconto 5%");
        } else if (this.cliente.getTipoRaw().equals("Pessoa Juridica") && this.diasAlugados > 10){
            return ("Valor previsto: R$ " + ((this.valorPrevisto.subtract(this.valorPrevisto.multiply(BigDecimal.valueOf(0.10))))+ "Desconto 10%");
        }
        return ("Valor previsto: R$ " + this.valorPrevisto);
    };
    public void encerrarAluguel(){
        this.emAberto = false;
    }
   public String getCliente() {
        return this.cliente.getNome();
    }
    public String getVeiculo(){
        TipoVeiculo tV = this.veiculo.getTipo();
        return ("ID: "+this.veiculo.getId() + "MODELO: " +this.veiculo.getModelo() + "TIPO: " + tV.getDescricao());
    }
    public String getAgencias(){
        return(
                "Agencia Retirada: " + this.agenciaRetirada + "Agencia Devolucao: " + this.agenciaDevolucao
                );
    }

    public String getDatas(){
        return(
                "Data Retirada: " + this.dataRetirada.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "Data Devolucao: " + this.dataDevolucaoPrevista.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "("+ diasAlugados + " dias)"
        );
    }

    public void diaFinal(Integer totalDias){
        this.diasAlugados = totalDias;
    };
}
