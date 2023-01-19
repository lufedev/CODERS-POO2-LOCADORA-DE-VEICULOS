package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.exception.RegistroDuplicadoException;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.persistence.TipoVeiculoRepository;

import java.math.BigDecimal;
import java.util.List;

public class TipoVeiculoManager {

    private final TipoVeiculoRepository tipoVeiculoRepository;

    public TipoVeiculoManager(TipoVeiculoRepository tipoVeiculoRepository) {
        this.tipoVeiculoRepository = tipoVeiculoRepository;
    }

    public TipoVeiculo criarTipoVeiculo(String descricao, BigDecimal tarifa) {
        if (existeTipoVeiculo(descricao)) {
            throw new RegistroDuplicadoException("Tipo de Veículo", descricao);
        }

        TipoVeiculo novoTipoVeiculo = new TipoVeiculo(descricao, tarifa);
        tipoVeiculoRepository.salvar(novoTipoVeiculo);
        return novoTipoVeiculo;
    }

    public void removerTipoVeiculo(TipoVeiculo tipoVeiculo) {
        tipoVeiculoRepository.remover(tipoVeiculo);
    }

    public List<TipoVeiculo> buscarTodosTipoVeiculos() {
        return tipoVeiculoRepository.listarTodos();
    }
    
    public TipoVeiculo buscarTipoVeiculoPorId(String descricao) {
        return tipoVeiculoRepository.buscarPeloId(descricao);
    }

    public boolean existeTipoVeiculo(String descricao) {
        return tipoVeiculoRepository.buscarPeloId(descricao) != null;
    }

}