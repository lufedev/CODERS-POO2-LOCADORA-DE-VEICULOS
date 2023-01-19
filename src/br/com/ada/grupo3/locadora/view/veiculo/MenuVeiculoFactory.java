package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;

import java.util.List;

public class MenuVeiculoFactory implements MenuFactory {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final List<TipoVeiculo> tiposDeVeiculos;

    public MenuVeiculoFactory(VeiculoManager gerenciadorDeVeiculo, List<TipoVeiculo> tiposDeVeiculos) {
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.tiposDeVeiculos = tiposDeVeiculos;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuVeiculos = new MenuComSubmenus("Menu Veiculos");

        Menu menuCadastrarVeiculo = new MenuCadastrarVeiculo(gerenciadorDeVeiculo, tiposDeVeiculos);
        menuVeiculos.adicionarSubmenu(menuCadastrarVeiculo);

        Menu menuRemoverVeiculo = new MenuRemoverVeiculo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuRemoverVeiculo);

        Menu menuAlterarVeiculo = new MenuAlterarVeiculo(gerenciadorDeVeiculo, tiposDeVeiculos);
        menuVeiculos.adicionarSubmenu(menuAlterarVeiculo);

        Menu menuBuscarVeiculoPorModelo = new MenuBuscarVeiculoPorModelo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuBuscarVeiculoPorModelo);

        Menu menuListarVeiculos = new MenuListarVeiculos(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuListarVeiculos);

        Menu menuVolta = new MenuVolta();
        menuVeiculos.adicionarSubmenu(menuVolta);

        return menuVeiculos;
    }
}
