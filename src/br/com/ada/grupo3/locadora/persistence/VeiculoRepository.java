package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends GenericRepository<Veiculo> {

    List<Veiculo> buscarPeloModelo(String modelo);
}
