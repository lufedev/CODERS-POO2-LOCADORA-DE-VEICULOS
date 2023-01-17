package br.com.ada.grupo3.locadora.persistence;
import br.com.ada.grupo3.locadora.model.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> buscarPeloNome(String parteNome);
}
