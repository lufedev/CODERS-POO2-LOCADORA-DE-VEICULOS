package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Agencia;

import java.util.List;

public interface AgenciaRepository {

    List<Agencia> buscarPeloLogradouro(String parteLogradouro);
}
