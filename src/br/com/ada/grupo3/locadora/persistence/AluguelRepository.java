package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Aluguel;

import java.util.List;

public interface AluguelRepository extends GenericRepository<Aluguel> {

    List<Aluguel> buscarPeloNome(String parteNome);

}
