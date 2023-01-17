package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Aluguel;

import java.util.List;

public class AluguelRepositoryInMemory extends GenericRepositoryInMemory<Aluguel> implements AluguelRepository {

    @Override
    public List<Aluguel> buscarPeloNome(String parteNome) {
        return null;
    }
}

