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

    @Override
    public String getId() {
        return id;
    }

    public String calcularPreco(){

        TipoVeiculo tV = this.veiculo.getTipo();
//        switch(tV.getDescricao()){
//            case ("Carro"):
//                this.valorPrevisto  =BigDecimal.valueOf(150L * diasAlugados);
//                System.out.println("Valor total => R$" + this.valorPrevisto );
//                break;
//            case ("Moto"):
//                this.valorPrevisto  =BigDecimal.valueOf( 100L * diasAlugados);
//                System.out.println("Valor total => R$" + this.valorPrevisto );
//                break;
//            case ("Caminhão"):
//                this.valorPrevisto  = BigDecimal.valueOf(200L * diasAlugados);
//                System.out.println("Valor total => R$" + this.valorPrevisto );
//                break;
//                }
        Long tarifa = Long.valueOf(tV.getTarifa());
        this.valorPrevisto  = BigDecimal.valueOf(tarifa * diasAlugados);
        System.out.println("Valor total => R$" + this.valorPrevisto );


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
    public String getStatus(){
        if(emAberto){
            return( "Aberto");
        }
        else{
            return ("Encerrado");
        }
    }
    public String getCliente() {
        return this.cliente.getNome();
    }
    public String getVeiculo(){
        TipoVeiculo tV = this.veiculo.getTipo();
        return ("\n   Id => "+this.veiculo.getId() + " | Modelo => " +this.veiculo.getModelo() + " | Tipo => " + tV.getDescricao());
    }
    public String getVeiculoId(){
        return this.veiculo.getId();
    }
    public String getAgencias(){
        return(
                "Agencia Retirada => " + this.agenciaRetirada + "\nAgencia Devolucao => " + this.agenciaDevolucao
        );
    }

    public String getDatas(){
        return(
                "Data Retirada => " + this.dataRetirada.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\nData Devolucao => " + this.dataDevolucaoPrevista.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " ("+ diasAlugados + " dias)"
        );
    }

    public void diaFinal(Integer totalDias){
        if (!totalDias.equals(this.diasAlugados)){
            this.diasAlugados = totalDias;
            this.dataDevolucaoPrevista = dataRetirada.plus(diasAlugados, ChronoUnit.DAYS);
            calcularPreco();
        };

    };

    public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
        this.agenciaDevolucao = agenciaDevolucao;
    }

    public void setAgenciaRetirada(Agencia agenciaRetirada) {
        this.agenciaRetirada = agenciaRetirada;
    }

    public String getAgenciaDevolucaoId() {
        return this.agenciaDevolucao.getId();
    }

    public String getAgenciaRetiradaId() {
        return this.agenciaRetirada.getId();
    }

    public String getMotorista() {
        return this.motorista.getNome();
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public Integer getDiasAlugados() {
        return diasAlugados;
    }

    public String basic(){
        return ("""
                ID: %s
                STATUS: %s
                CONTRATANTE: %s
                
                """.formatted(id,getStatus(),cliente));
    }

    @Override
    public String toString(){
        return (
                """
                ==========CONTRATO: %s STATUS: %s==============
                Contratante: %s
                Motorista: %s
                Veiculo: %s
                %s
                %s
                %s
             
                """.formatted(id,getStatus(),cliente,motorista,veiculo,getAgencias(),getDatas(),calcularPreco()));
    }
}

