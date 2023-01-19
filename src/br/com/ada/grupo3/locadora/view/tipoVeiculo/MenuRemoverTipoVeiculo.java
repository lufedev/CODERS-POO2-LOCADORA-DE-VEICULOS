package br.com.ada.grupo3.locadora.view.tipoVeiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuRemoverTipoVeiculo extends MenuAbstrato {

    private final TipoVeiculoManager gerenciadorDeTipoVeiculo;

    public MenuRemoverTipoVeiculo(TipoVeiculoManager gerenciadorDeTipoVeiculo) {
        super("Remover tipo de veículo");
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {
        String descricao = CapturadorDeEntrada.capturarString("tipo de veículo a ser removido");

        while (!gerenciadorDeTipoVeiculo.existeTipoVeiculo(descricao)) {
            System.out.println("Não existe tipo de veículo com essa descrição " + descricao);
            descricao = CapturadorDeEntrada.capturarString("tipo de veículo a ser removido ou <0> para cancelar operacao");
            if (descricao.equals("0")) return;
        }

        TipoVeiculo tipoVeiculo = gerenciadorDeTipoVeiculo.buscarTipoVeiculoPorId(descricao);

        gerenciadorDeTipoVeiculo.removerTipoVeiculo(tipoVeiculo);

        System.out.printf("Tipo de veículo %s removido com sucesso%n", descricao);
    }
}
