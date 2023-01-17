package br.com.ada.grupo3.locadora.view;

import br.com.ada.grupo3.locadora.view.agencia.MenuAgenciasFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuAgenciasFactory menuAgenciasFactory;

    public MenuGeralFactory(MenuAgenciasFactory menuAgenciasFactory) {
        this.menuAgenciasFactory = menuAgenciasFactory;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuGeral = new MenuGeral("LocateCar - Locadora de veiculos");

        Menu menuAgencias = menuAgenciasFactory.create();
        menuGeral.adicionarSubmenu(menuAgencias);

        Menu menuClientes = new MenuComSubmenus("Menu Clientes");
        menuGeral.adicionarSubmenu(menuClientes);
        return menuGeral;
    }
}
