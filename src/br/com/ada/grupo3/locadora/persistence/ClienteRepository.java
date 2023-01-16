package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Cliente;

import java.util.List;

public interface ClienteRepository<Cliente> {
    List<Cliente> buscarPeloNome(String parteNome);

    void alterarCliente(String id);

    Cliente cadastrarCliente(boolean cadastroCompleto);
}
