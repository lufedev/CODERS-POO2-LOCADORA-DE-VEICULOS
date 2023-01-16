package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends RepositoryGenerico<Veiculo> {
    List<Veiculo> buscarPeloModelo(String modelo);

}
