package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositoryInMemory extends GenericRepositoryInMemory<Agencia> implements AgenciaRepository {

    @Override
    public List<Agencia> buscarPeloLogradouro(String parteLogradouro) {
        List<Agencia> agenciasComParteDesseNome = new ArrayList<>();
        for (Agencia agencia : entidades.values()) {
            if (agencia.getLogradouro().contains(parteLogradouro)) {
                agenciasComParteDesseNome.add(agencia);
            }
        }
        return agenciasComParteDesseNome;
    }
}
