package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositoryInMemory extends GenericRepositoryInMemory<Veiculo> implements VeiculoRepository {
    @Override
    public List<Veiculo> buscarPeloModelo(String parteModelo) {
        List<Veiculo> veiculosComParteDesseModelo = new ArrayList<>();
        for (Veiculo veiculo : entidades.values()) {
            if (veiculo.getModelo().contains(parteModelo)) {
                veiculosComParteDesseModelo.add(veiculo);
            }
        }
        return veiculosComParteDesseModelo;
    }
}

