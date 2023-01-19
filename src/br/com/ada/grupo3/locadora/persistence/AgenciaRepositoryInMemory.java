package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositoryInMemory extends GenericRepositoryInMemory<Agencia> implements AgenciaRepository {

    @Override
    public List<Agencia> buscarPeloNome(String parteNome) {
        List<Agencia> agenciasComParteDesseNome = new ArrayList<>();
        for (Agencia agencia : entidades.values()) {
            if (agencia.getNome().contains(parteNome)) {
                agenciasComParteDesseNome.add(agencia);
            }
        }
        return agenciasComParteDesseNome;
    }

    @Override
    public List<Agencia> buscarPeloLogradouro(String parteLogradouro) {
        List<Agencia> agenciasComParteDesseLogradouro = new ArrayList<>();
        for (Agencia agencia : entidades.values()) {
            if (agencia.getLogradouro().contains(parteLogradouro)) {
                agenciasComParteDesseLogradouro.add(agencia);
            }
        }
        return agenciasComParteDesseLogradouro;
    }
}
