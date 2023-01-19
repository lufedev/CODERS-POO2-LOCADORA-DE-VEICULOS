package br.com.ada.grupo3.locadora.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Aluguel implements Entidade {

    private UUID id;
    private Cliente cliente;
    private Veiculo veiculo;
    private Agencia agenciaRetirada;
    private Agencia agenciaDevolucao;
    private LocalDateTime dataRetirada;
    private Integer diasAlugados;
    private LocalDateTime dataDevolucaoPrevista;
    private BigDecimal valorAluguel;

    public Aluguel(Cliente cliente, Veiculo veiculo, Agencia agenciaRetirada, Agencia agenciaDevolucao, LocalDateTime dataRetirada, Integer diasAlugados) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.agenciaRetirada = agenciaRetirada;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataRetirada.plus(diasAlugados, ChronoUnit.DAYS) ;
        this.valorAluguel = null;
    }

    public String getId() {
        return id.toString();
    }

    public Cliente getCliente() {
        return cliente;
    }
}
