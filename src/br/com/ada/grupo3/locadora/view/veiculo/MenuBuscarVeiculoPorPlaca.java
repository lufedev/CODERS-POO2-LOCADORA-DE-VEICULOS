package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuBuscarVeiculoPorPlaca extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuBuscarVeiculoPorPlaca(VeiculoManager gerenciadorDeVeiculo) {
        super("Buscar veículo por placa");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("placa do veículo buscado");

        List<Veiculo> veiculosComPlacaBuscada = gerenciadorDeVeiculo.buscarVeiculoPelaPlacaParcial(placa);

        if (veiculosComPlacaBuscada.isEmpty()) {
            System.out.println("Não existe veículo com o placa " + placa);
            return;
        }
        listarVeiculos(veiculosComPlacaBuscada);
    }

    public void listarVeiculos(List<Veiculo> veiculosComPlacaBuscada) {
        veiculosComPlacaBuscada.forEach(System.out::println);
    }
}
