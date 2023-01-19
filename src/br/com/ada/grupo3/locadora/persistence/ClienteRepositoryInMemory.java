package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteRepositoryInMemory extends GenericRepositoryInMemory<Cliente> implements ClienteRepository {
    @Override
    public List<Cliente> buscarPeloNome(String parteNome) {
        List<Cliente> clientesComParteDesseNome = new ArrayList<>();
        for (Cliente cliente : entidades.values()) {
            if (cliente.getNome().contains(parteNome)) {
                clientesComParteDesseNome.add(cliente);
            }
        }
        return clientesComParteDesseNome;
    }
    public Map<String, Cliente> getEntidades(){
        return this.entidades;
    }
}

