package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuCadastrarVeiculo extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final List<TipoVeiculo> tiposDeVeiculos;

    public MenuCadastrarVeiculo(VeiculoManager gerenciadorDeVeiculo, List<TipoVeiculo> tiposDeVeiculos) {
        super("Adicionar veiculo");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.tiposDeVeiculos = tiposDeVeiculos;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("placa do novo veiculo");

        while (gerenciadorDeVeiculo.existeVeiculo(placa)) {
            System.out.println("Já existe uma veiculo com a placa " + placa);
            placa = CapturadorDeEntrada.capturarString("placa do novo veiculo");
        }
        String modelo = CapturadorDeEntrada.capturarString("modelo do novo veiculo");
        String fabricante = CapturadorDeEntrada.capturarString("fabricante do novo veiculo");
        TipoVeiculo tipo = CapturadorDeEntrada.capturaSelecao(tiposDeVeiculos);
        Veiculo veiculo = gerenciadorDeVeiculo.criarVeiculo(placa, modelo, fabricante, tipo);

        System.out.println("Veículo adicionado com sucesso");
        System.out.println("Novo Veículo:");
        System.out.println(veiculo);
    }
}
