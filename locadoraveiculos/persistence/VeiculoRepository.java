package br.com.ada.projeto.locadoraveiculos.persistence;

import br.com.ada.projeto.locadoraveiculos.model.Agencia;
import br.com.ada.projeto.locadoraveiculos.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends RepositoryGenerico<Veiculo> {
    List<Veiculo> buscarPeloModelo(String modelo);

}
