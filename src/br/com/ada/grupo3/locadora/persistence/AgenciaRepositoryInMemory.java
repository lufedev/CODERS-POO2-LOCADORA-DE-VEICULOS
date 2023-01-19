package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Agencia;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositoryInMemory extends GenericRepositoryInMemory<Agencia> implements AgenciaRepository {

    @Override
    public List<Agencia> buscarPeloNomeParcial(String parteNome) {
        List<Agencia> agenciasComParteDesseNome = new ArrayList<>();
        for (Agencia agencia : entidades.values()) {
            if (agencia.getNome().toLowerCase().contains(parteNome.toLowerCase())) {
                agenciasComParteDesseNome.add(agencia);
            }
        }
        return agenciasComParteDesseNome;
    }

    @Override
    public List<Agencia> buscarPeloLogradouroParcial(String parteLogradouro) {
        List<Agencia> agenciasComParteDesseLogradouro = new ArrayList<>();
        for (Agencia agencia : entidades.values()) {
            if (agencia.getLogradouro().toLowerCase().contains(parteLogradouro.toLowerCase())) {
                agenciasComParteDesseLogradouro.add(agencia);
            }
        }
        return agenciasComParteDesseLogradouro;
    }
}
