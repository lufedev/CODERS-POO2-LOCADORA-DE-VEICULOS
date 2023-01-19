package br.com.ada.grupo3.locadora.view.tipoVeiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuListarTiposVeiculo extends MenuAbstrato {

    private final TipoVeiculoManager gerenciadorDeTipoVeiculo;

    public MenuListarTiposVeiculo(TipoVeiculoManager gerenciadorDeTipoVeiculo) {
        super("Listar todos tipos de  veículos");
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {

        List<TipoVeiculo> tiposVeiculos = gerenciadorDeTipoVeiculo.buscarTodasTipoVeiculos();

        if (tiposVeiculos.isEmpty()) {
            System.out.println("A lista de tipos de veículos está vazia");
            return;
        }

        listarTipoVeiculos(tiposVeiculos);
    }

    public void listarTipoVeiculos(List<TipoVeiculo> tiposVeiculos) {
        tiposVeiculos.forEach(System.out::println);
    }
}
