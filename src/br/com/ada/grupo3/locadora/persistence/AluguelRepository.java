package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Cliente;

import java.util.List;

public interface AluguelRepository extends GenericRepository<Aluguel> {

    List<Aluguel> buscarPeloCliente(Cliente cliente);

    List<Aluguel> buscarPeloNomeParcial(String parteUUID);

    List<String> listarTodosAlugueis();
    List<String> listarTodosAlugueisAbertos();
}
