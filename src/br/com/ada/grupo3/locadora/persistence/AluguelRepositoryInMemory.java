package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AluguelRepositoryInMemory extends GenericRepositoryInMemory<Aluguel> implements AluguelRepository {

    @Override
    public List<Aluguel> buscarPeloCliente(Cliente cliente) {
        List<Aluguel> alugueisParaEsseCliente = new ArrayList<>();
        for (Aluguel aluguel : entidades.values()) {
            if (aluguel.getCliente().equals(cliente)) {
                alugueisParaEsseCliente.add(aluguel);
            }
        }
        return alugueisParaEsseCliente;
    }
}

