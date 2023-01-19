package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;

public class MenuClienteFactory implements MenuFactory {

    private final ClienteManager gerenciadorDeCliente;

    public MenuClienteFactory(ClienteManager gerenciadorDeCliente) {
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuClientes = new MenuComSubmenus("Menu Clientes");

        Menu menuAdicionarCliente = new MenuCadastrarCliente(gerenciadorDeCliente);
        menuClientes.adicionarSubmenu(menuAdicionarCliente);

        Menu menuBuscarClientePorNome = new MenuBuscarClientePorNome(gerenciadorDeCliente);
        menuClientes.adicionarSubmenu(menuBuscarClientePorNome);

        Menu menuVolta = new MenuVolta();
        menuClientes.adicionarSubmenu(menuVolta);

        return menuClientes;
    }
}
