package br.com.ada.grupo3.locadora.view;

import br.com.ada.grupo3.locadora.view.agencia.MenuAgenciaFactory;
import br.com.ada.grupo3.locadora.view.aluguel.MenuAluguelFactory;
import br.com.ada.grupo3.locadora.view.cliente.MenuClienteFactory;
import br.com.ada.grupo3.locadora.view.veiculo.MenuVeiculoFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuVeiculoFactory menuVeiculoFactory;
    private final MenuAgenciaFactory menuAgenciaFactory;
    private final MenuClienteFactory menuClienteFactory;
    private final MenuAluguelFactory menuAluguelFactory;

    public MenuGeralFactory(MenuVeiculoFactory menuVeiculoFactory, MenuAgenciaFactory menuAgenciaFactory,
                            MenuClienteFactory menuClienteFactory, MenuAluguelFactory menuAluguelFactory) {
        this.menuVeiculoFactory = menuVeiculoFactory;
        this.menuAgenciaFactory = menuAgenciaFactory;
        this.menuClienteFactory = menuClienteFactory;
        this.menuAluguelFactory = menuAluguelFactory;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuGeral = new MenuGeral("LocateCar - Locadora de veiculos");

        Menu menuVeiculos = menuVeiculoFactory.create();
        menuGeral.adicionarSubmenu(menuVeiculos);

        Menu menuAgencias = menuAgenciaFactory.create();
        menuGeral.adicionarSubmenu(menuAgencias);

        Menu menuCliente = menuClienteFactory.create();
        menuGeral.adicionarSubmenu(menuCliente);

        Menu menuAluguel = menuAluguelFactory.create();
        menuGeral.adicionarSubmenu(menuAluguel);

        Menu menuSair = new MenuSair();
        menuGeral.adicionarSubmenu(menuSair);

        return menuGeral;
    }
}
