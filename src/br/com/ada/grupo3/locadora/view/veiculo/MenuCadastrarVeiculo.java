package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuCadastrarVeiculo extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final TipoVeiculoManager gerenciadorTipoVeiculo;

    public MenuCadastrarVeiculo(VeiculoManager gerenciadorDeVeiculo, TipoVeiculoManager gerenciadorTipoVeiculo) {
        super("Adicionar veiculo");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorTipoVeiculo = gerenciadorTipoVeiculo;
    }

    @Override
    public void acao() {
        if (gerenciadorTipoVeiculo.buscarTodosTipoVeiculos().isEmpty()) {
            System.out.println("Não existe tipo de veículo cadastrado, cadastrar tipo de veículo antes de criar veículo");
            return;
        }

        String placa = CapturadorDeEntrada.capturarStringNaoVazia("placa do novo veiculo");

        while (gerenciadorDeVeiculo.existeVeiculo(placa)) {
            System.out.println("Já existe uma veiculo com a placa " + placa);
            placa = CapturadorDeEntrada.capturarString("placa do novo veiculo");
        }
        String modelo = CapturadorDeEntrada.capturarStringNaoVazia("modelo do novo veiculo");
        String fabricante = CapturadorDeEntrada.capturarStringNaoVazia("fabricante do novo veiculo");
        TipoVeiculo tipo = CapturadorDeEntrada.capturaSelecao(gerenciadorTipoVeiculo.buscarTodosTipoVeiculos());
        Veiculo veiculo = gerenciadorDeVeiculo.criarVeiculo(placa, modelo, fabricante, tipo);

        System.out.println("Veículo adicionado com sucesso");
        System.out.println("Novo Veículo:");
        System.out.println(veiculo);
    }
}
