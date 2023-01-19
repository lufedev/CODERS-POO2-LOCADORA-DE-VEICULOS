package br.com.ada.grupo3.locadora.view.tipoVeiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;

public class MenuTipoVeiculoFactory implements MenuFactory {

    private final TipoVeiculoManager gerenciadorDeTipoVeiculo;

    public MenuTipoVeiculoFactory(TipoVeiculoManager gerenciadorDeTipoVeiculo) {
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuTipoVeiculos = new MenuComSubmenus("Menu Tipos de Veículos");

        Menu menuAdicionarTipoVeiculo = new MenuCadastrarTipoVeiculo(gerenciadorDeTipoVeiculo);
        menuTipoVeiculos.adicionarSubmenu(menuAdicionarTipoVeiculo);

        Menu menuRemoverTipoVeiculo = new MenuRemoverTipoVeiculo(gerenciadorDeTipoVeiculo);
        menuTipoVeiculos.adicionarSubmenu(menuRemoverTipoVeiculo);

        Menu menuAlterarTipoVeiculo = new MenuAlterarTipoVeiculo(gerenciadorDeTipoVeiculo);
        menuTipoVeiculos.adicionarSubmenu(menuAlterarTipoVeiculo);

        Menu menuListarTipoVeiculos = new MenuListarTiposVeiculo(gerenciadorDeTipoVeiculo);
        menuTipoVeiculos.adicionarSubmenu(menuListarTipoVeiculos);

        Menu menuVolta = new MenuVolta();
        menuTipoVeiculos.adicionarSubmenu(menuVolta);

        return menuTipoVeiculos;
    }
}
