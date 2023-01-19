package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;

import br.com.ada.grupo3.locadora.view.tipoVeiculo.MenuTipoVeiculoFactory;


public class MenuVeiculoFactory implements MenuFactory {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final TipoVeiculoManager gerenciadorTipoVeiculo;

    public MenuVeiculoFactory(VeiculoManager gerenciadorDeVeiculo, TipoVeiculoManager gerenciadorTipoVeiculo) {
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorTipoVeiculo = gerenciadorTipoVeiculo;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuVeiculos = new MenuComSubmenus("Menu Veiculos");

        Menu menuCadastrarVeiculo = new MenuCadastrarVeiculo(gerenciadorDeVeiculo, gerenciadorTipoVeiculo);
        menuVeiculos.adicionarSubmenu(menuCadastrarVeiculo);

        Menu menuRemoverVeiculo = new MenuRemoverVeiculo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuRemoverVeiculo);

        Menu menuAlterarVeiculo = new MenuAlterarVeiculo(gerenciadorDeVeiculo, gerenciadorTipoVeiculo);
        menuVeiculos.adicionarSubmenu(menuAlterarVeiculo);

        Menu menuBuscarVeiculoPorModelo = new MenuBuscarVeiculoPorModelo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuBuscarVeiculoPorModelo);

        Menu menuBuscarVeiculoPorPlaca = new MenuBuscarVeiculoPorPlaca(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuBuscarVeiculoPorPlaca);

        Menu menuListarVeiculos = new MenuListarVeiculos(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuListarVeiculos);

        MenuTipoVeiculoFactory menuTipoVeiculoFactory = new MenuTipoVeiculoFactory(gerenciadorTipoVeiculo);

        Menu menuTipoVeiculo = menuTipoVeiculoFactory.create();
        menuVeiculos.adicionarSubmenu(menuTipoVeiculo);

        Menu menuVolta = new MenuVolta();
        menuVeiculos.adicionarSubmenu(menuVolta);

        return menuVeiculos;
    }
}
