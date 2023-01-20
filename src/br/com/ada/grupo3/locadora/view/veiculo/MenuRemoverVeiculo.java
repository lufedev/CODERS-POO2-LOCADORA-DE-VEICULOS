package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuRemoverVeiculo extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuRemoverVeiculo(VeiculoManager gerenciadorDeVeiculo) {
        super("Remover veiculo");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {

        String placa = CapturadorDeEntrada.capturarString("placa do veiculo a ser removido");

        while (!gerenciadorDeVeiculo.existeVeiculo(placa)) {
            System.out.println("Não existe um veiculo com a placa " + placa);
            placa = CapturadorDeEntrada.capturarString("placa do veículo a ser removido ou <0> para cancelar operacao");
            if (placa.equals("0")) return;
        }
        Veiculo veiculo = gerenciadorDeVeiculo.buscarVeiculoPorID(placa);
        gerenciadorDeVeiculo.removerVeiculo(veiculo);
        System.out.printf("Veículo placa %s removido com sucesso%n", placa);
    }
}
