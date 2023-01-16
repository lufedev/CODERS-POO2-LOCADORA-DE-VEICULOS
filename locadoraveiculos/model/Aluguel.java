package br.com.ada.projeto.locadoraveiculos.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Aluguel implements Entidade {

    private UUID id;

    private Cliente cliente;

    private Veiculo veiculo;

    private Agencia agenciaRetirada;

    private Agencia agenciaDevolucao;

    private LocalDateTime dataRetirada;

    private LocalDateTime dataDevolucao;

    public Aluguel(Cliente cliente, Veiculo veiculo, Agencia agenciaRetirada, Agencia agenciaDevolucao, LocalDateTime dataRetirada, LocalDateTime dataDevolucao) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.agenciaRetirada = agenciaRetirada;
        this.agenciaDevolucao = agenciaDevolucao;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    public String getId() {
        return id.toString();
    }
}
