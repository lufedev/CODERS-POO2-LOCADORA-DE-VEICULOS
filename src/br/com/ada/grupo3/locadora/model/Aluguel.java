package br.com.ada.grupo3.locadora.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

public class Aluguel implements Entidade {
    private boolean emAberto;
    private String id;

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
        this.id = UUID.randomUUID().toString().substring(0,7);
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

    public Aluguel(boolean emAberto, String id, Cliente cliente, Cliente motorista, Veiculo veiculo, Agencia agenciaRetirada,
                   Agencia agenciaDevolucao, LocalDateTime dataRetirada, Integer diasAlugados, LocalDateTime dataDevolucaoPrevista,
                   BigDecimal valorAluguel, BigDecimal valorPrevisto) {
        this.emAberto = emAberto;
        this.id = id;
        this.cliente = cliente;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.agenciaRetirada = agenciaRetirada;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataRetirada = dataRetirada;
        this.diasAlugados = diasAlugados;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.valorAluguel = valorAluguel;
        this.valorPrevisto = valorPrevisto;
    }

    public Aluguel getAluguel(){
       return new Aluguel (this.emAberto, this.id, this.cliente, this.motorista, this.veiculo, this.agenciaRetirada,
               this.agenciaDevolucao, this.dataRetirada, this.diasAlugados, this.dataDevolucaoPrevista, this.valorAluguel, this.valorPrevisto);
    }

    @Override
    public String getId() {
        return id;
    }

    public String calcularPreco(){

        TipoVeiculo tV = this.veiculo.getTipo();
        switch(tV.getDescricao()){
            case ("Carro"):
                this.valorPrevisto  =BigDecimal.valueOf(150L * diasAlugados);
                System.out.println("Valor total => R$" + this.valorPrevisto );
                break;
            case ("Moto"):
                this.valorPrevisto  =BigDecimal.valueOf( 100L * diasAlugados);
                System.out.println("Valor total => R$" + this.valorPrevisto );
                break;
            case ("Caminhão"):
                this.valorPrevisto  = BigDecimal.valueOf(200L * diasAlugados);
                System.out.println("Valor total => R$" + this.valorPrevisto );
                break;

        }
        if (this.cliente.getTipoRaw().equals("Pessoa Fisica") && this.diasAlugados > 5) {
            return ("Valor final => R$ " + ((this.valorPrevisto.subtract(this.valorPrevisto.multiply(BigDecimal.valueOf(0.05))))+ " (desconto 5%)"));
        } else if (this.cliente.getTipoRaw().equals("Pessoa Juridica") && this.diasAlugados > 10){
            return ("Valor final => R$ " + ((this.valorPrevisto.subtract(this.valorPrevisto.multiply(BigDecimal.valueOf(0.10))))+ " (desconto 10%)"));
        }
        return ("Valor final => R$ " + this.valorPrevisto);
    };
    public void encerrarAluguel(){
        this.emAberto = false;
    }
    public String getCliente() {
        return this.cliente.getNome();
    }
    public String getVeiculo(){
        TipoVeiculo tV = this.veiculo.getTipo();
        return ("\n   Id => "+this.veiculo.getId() + " | Modelo => " +this.veiculo.getModelo() + " | Tipo => " + tV.getDescricao());
    }
    public String getAgencias(){
        return(
                "Agencia Retirada => " + this.agenciaRetirada + "\nAgencia Devolucao => " + this.agenciaDevolucao
        );
    }

    public String getDatas(){
        return(
                "Data Retirada => " + this.dataRetirada.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\nData Devolucao => " + this.dataDevolucaoPrevista.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ("+ diasAlugados + " dias)"
        );
    }

    public void diaFinal(Integer totalDias){
        this.diasAlugados = totalDias;
    };

    @Override
    public String toString(){
        return (
                """
                =========CONTRATO: %s ==============
                Contratante: %s
                Motorista: %s
                Veiculo: %s
                %s
                %s
                %s
             
                """.formatted(id,cliente,motorista,veiculo,getAgencias(),getDatas(),calcularPreco()));
    }
}

