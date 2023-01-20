package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.List;

public class MenuListarVeiculos extends MenuAbstrato {

    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuListarVeiculos(VeiculoManager gerenciadorDeVeiculo) {
        super("Listar todos veículos");
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {

        List<Veiculo> veiculos = gerenciadorDeVeiculo.buscarTodosVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("A lista de veículos está vazia");
            return;
        }

        listarVeiculos(veiculos);
    }

    public void listarVeiculos(List<Veiculo> veiculos) {
        PaginacaoListas.listarEmPaginas(veiculos, "Lista de veículos");

    }
}
