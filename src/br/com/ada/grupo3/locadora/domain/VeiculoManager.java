package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.exception.RegistroDuplicadoException;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepository;

import java.util.List;


public class VeiculoManager {

    private final VeiculoRepository veiculoRepository;

    public VeiculoManager(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo criarVeiculo(String placa, String modelo, String fabricante, TipoVeiculo tipo) {
        if (existeVeiculo(placa)) {
            throw new RegistroDuplicadoException("Veiculo", placa);
        }

        Veiculo novoVeiculo = new Veiculo(placa, modelo, fabricante, tipo);
        veiculoRepository.salvar(novoVeiculo);
        return novoVeiculo;
    }

    public Veiculo alterarVeiculo(String placa) {
//        if (existeVeiculo(placa)) {
//            throw new RegistroDuplicadoException("Veiculo", placa);
//        }
//
//        Veiculo novoVeiculo = new Veiculo(placa, modelo, fabricante, tipo);
//        veiculoRepository.salvar(novoVeiculo);
//        return novoVeiculo;
        return veiculoRepository.buscarPeloId("0");
    }

    public Veiculo buscarVeiculoPorID(String placa){
        return veiculoRepository.buscarPeloId(placa);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculoRepository.remover(veiculo);
    }


    public List<Veiculo> buscarVeiculoPorModelo(String parteModelo) {
        return veiculoRepository.buscarPeloModelo(parteModelo);
    }

    public boolean existeVeiculo(String placa) {
        return veiculoRepository.buscarPeloId(placa) != null;
    }
}
