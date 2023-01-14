package br.com.ada.projeto.locadoraveiculos.persistence;

import br.com.ada.projeto.locadoraveiculos.model.Cliente;

import java.util.List;

public interface ClienteRepository<Cliente> {
    List<Cliente> buscarPeloNome(String parteNome);
    void alterarCliente(String id);

    Cliente cadastrarCliente(boolean cadastroCompleto);




}
