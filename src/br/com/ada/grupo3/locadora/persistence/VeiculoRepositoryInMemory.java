package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositoryInMemory extends GenericRepositoryInMemory<Veiculo> implements VeiculoRepository {
    @Override
    public List<Veiculo> buscarPeloModeloParcial(String parteModelo) {
        List<Veiculo> veiculosComParteDesseModelo = new ArrayList<>();
        for (Veiculo veiculo : entidades.values()) {
            if (veiculo.getModelo().toLowerCase().contains(parteModelo.toLowerCase())) {
                veiculosComParteDesseModelo.add(veiculo);
            }
        }
        return veiculosComParteDesseModelo;
    }

    @Override
    public List<Veiculo> buscarPelaPlacaParcial(String partePlaca) {
        List<Veiculo> veiculosComParteDessaPlaca = new ArrayList<>();
        for (Veiculo veiculo : entidades.values()) {
            if (veiculo.getPlaca().toLowerCase().contains(partePlaca.toLowerCase())) {
                veiculosComParteDessaPlaca.add(veiculo);
            }
        }
        return veiculosComParteDessaPlaca;

    }


}

