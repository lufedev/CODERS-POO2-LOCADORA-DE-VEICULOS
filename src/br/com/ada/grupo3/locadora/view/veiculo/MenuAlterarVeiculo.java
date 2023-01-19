package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuAlterarVeiculo extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final List<TipoVeiculo> tiposDeVeiculos;

    public MenuAlterarVeiculo(VeiculoManager gerenciadorDeVeiculo, List<TipoVeiculo> tiposDeVeiculos) {
        super("Alterar veiculo");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.tiposDeVeiculos = tiposDeVeiculos;
    }

    @Override
    public void acao() {

        String placa = CapturadorDeEntrada.capturarString("placa do veiculo a ser alterado");

        while (!gerenciadorDeVeiculo.existeVeiculo(placa)) {
            System.out.println("Não existe um veiculo com a placa " + placa);
            placa = CapturadorDeEntrada.capturarString("placa do veículo a ser alterado ou <0> para cancelar operacao");
            if (placa.equals("0")) return;
        }
        Veiculo veiculo = gerenciadorDeVeiculo.buscarVeiculoPorID(placa);

        String modelo = CapturadorDeEntrada.capturarString("modelo do veiculo");
        String fabricante = CapturadorDeEntrada.capturarString("fabricante do veiculo");
        TipoVeiculo tipo = CapturadorDeEntrada.capturaSelecao(tiposDeVeiculos);
        gerenciadorDeVeiculo.removerVeiculo(veiculo);
        veiculo = gerenciadorDeVeiculo.criarVeiculo(placa, modelo, fabricante, tipo);

        System.out.println("Veículo editado com sucesso");
        System.out.println("Veículo:");
        System.out.println(veiculo);
    }
}
