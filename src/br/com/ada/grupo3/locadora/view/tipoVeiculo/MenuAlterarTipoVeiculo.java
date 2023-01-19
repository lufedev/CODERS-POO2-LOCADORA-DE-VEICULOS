package br.com.ada.grupo3.locadora.view.tipoVeiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.math.BigDecimal;

public class MenuAlterarTipoVeiculo extends MenuAbstrato {

    private final TipoVeiculoManager gerenciadorDeTipoVeiculo;

    public MenuAlterarTipoVeiculo(TipoVeiculoManager gerenciadorDeTipoVeiculo) {
        super("Alterar tipo de veículo");
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {

        String descricao = CapturadorDeEntrada.capturarString("tipo de veículo a ser alterado");

        while (!gerenciadorDeTipoVeiculo.existeTipoVeiculo(descricao)) {
            System.out.println("Não existe um tipo de veículo com a descrição " + descricao);
            descricao = CapturadorDeEntrada.capturarString("tipo de veículo a ser alterado ou <0> para cancelar operação");
            if (descricao.equals("0")) return;
        }
        TipoVeiculo tipoVeiculo = gerenciadorDeTipoVeiculo.buscarTipoVeiculoPorId(descricao);

        BigDecimal tarifa = new BigDecimal(CapturadorDeEntrada.capturarString("tarifa para este tipo de veículo"));

        gerenciadorDeTipoVeiculo.removerTipoVeiculo(tipoVeiculo);
        tipoVeiculo = gerenciadorDeTipoVeiculo.criarTipoVeiculo(descricao, tarifa);

        System.out.println("Tipo de veículo editado com sucesso");
        System.out.println("Tipo de veículo:");
        System.out.println(tipoVeiculo);
    }
}
