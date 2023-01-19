package br.com.ada.grupo3.locadora.view.veiculo;

import br.com.ada.grupo3.locadora.domain.TipoVeiculoManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.persistence.TipoVeiculoRepository;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;
import br.com.ada.grupo3.locadora.view.tipoVeiculo.MenuCadastrarTipoVeiculo;
import br.com.ada.grupo3.locadora.view.tipoVeiculo.MenuListarTiposVeiculo;
import br.com.ada.grupo3.locadora.view.tipoVeiculo.MenuTipoVeiculoFactory;


public class MenuVeiculoFactory implements MenuFactory {

    private final VeiculoManager gerenciadorDeVeiculo;
    private final TipoVeiculoRepository tipoVeiculoRepository;

    public MenuVeiculoFactory(VeiculoManager gerenciadorDeVeiculo, TipoVeiculoRepository tipoVeiculoRepository) {
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.tipoVeiculoRepository = tipoVeiculoRepository;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuVeiculos = new MenuComSubmenus("Menu Veiculos");

        Menu menuCadastrarVeiculo = new MenuCadastrarVeiculo(gerenciadorDeVeiculo, tipoVeiculoRepository);
        menuVeiculos.adicionarSubmenu(menuCadastrarVeiculo);

        Menu menuRemoverVeiculo = new MenuRemoverVeiculo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuRemoverVeiculo);

        Menu menuAlterarVeiculo = new MenuAlterarVeiculo(gerenciadorDeVeiculo, tipoVeiculoRepository);
        menuVeiculos.adicionarSubmenu(menuAlterarVeiculo);

        Menu menuBuscarVeiculoPorModelo = new MenuBuscarVeiculoPorModelo(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuBuscarVeiculoPorModelo);

        Menu menuListarVeiculos = new MenuListarVeiculos(gerenciadorDeVeiculo);
        menuVeiculos.adicionarSubmenu(menuListarVeiculos);

        TipoVeiculoManager gerenciadorDeTipoVeiculo = new TipoVeiculoManager(tipoVeiculoRepository);
        MenuTipoVeiculoFactory menuTipoVeiculoFactory = new MenuTipoVeiculoFactory(gerenciadorDeTipoVeiculo);

        Menu menuTipoVeiculo = menuTipoVeiculoFactory.create();
        menuVeiculos.adicionarSubmenu(menuTipoVeiculo);

        Menu menuVolta = new MenuVolta();
        menuVeiculos.adicionarSubmenu(menuVolta);

        return menuVeiculos;
    }
}
