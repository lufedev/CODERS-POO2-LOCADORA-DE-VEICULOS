package br.com.ada.grupo3.locadora.view.tipoVeiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.math.BigDecimal;

public class MenuCadastrarTipoVeiculo extends MenuAbstrato {

    private final TipoVeiculoManager gerenciadorDeTipoVeiculo;

    public MenuCadastrarTipoVeiculo(TipoVeiculoManager gerenciadorDeTipoVeiculo) {
        super("Adicionar tipo de veículo");
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {
        String descricao = CapturadorDeEntrada.capturarStringNaoVazia("descrição do novo tipo de veículo");

        while (gerenciadorDeTipoVeiculo.existeTipoVeiculo(descricao)) {
            System.out.println("Já existe um tipo de veículo com essa descrição " + descricao);
            descricao = CapturadorDeEntrada.capturarStringNaoVazia("descrição do novo tipo de veículo");
        }
        BigDecimal tarifa = CapturadorDeEntrada.capturarBigDecimal("tarifa para este tipo de veículo");
        TipoVeiculo tipoVeiculo = gerenciadorDeTipoVeiculo.criarTipoVeiculo(descricao, tarifa);

        System.out.println("Tipo de veículo adicionado com sucesso");
        System.out.println("Novo tipo de veículo:");
        System.out.println(tipoVeiculo);
    }
}
