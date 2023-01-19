package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuBuscarVeiculoPorModelo extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuBuscarVeiculoPorModelo(VeiculoManager gerenciadorDeVeiculo) {
        super("Buscar veículo por modelo");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {
        String modelo = CapturadorDeEntrada.capturarString("modelo do veículo buscado");

        List<Veiculo> veiculosDoModeloBuscado = gerenciadorDeVeiculo.buscarVeiculoPorModelo(modelo);

        if (veiculosDoModeloBuscado.size() >= 1) {
            listarVeiculos(veiculosDoModeloBuscado);
            return;
        }
        System.out.println("Não existe veículo com o modelo " + modelo);
    }

    public void listarVeiculos(List<Veiculo> veiculos) {
        veiculos.forEach(System.out::println);
    }
}
