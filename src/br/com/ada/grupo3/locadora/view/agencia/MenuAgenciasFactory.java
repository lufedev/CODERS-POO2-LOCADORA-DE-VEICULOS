package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;

public class MenuAgenciasFactory implements MenuFactory {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuAgenciasFactory(AgenciaManager gerenciadorDeAgencia) {
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAgencias = new MenuComSubmenus("Menu Agencias");

        Menu menuAdicionarAgencia = new MenuAdicionarAgencia(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuAdicionarAgencia);

        Menu menuBuscarAgenciaPorNome = new MenuBuscarAgenciaPorNome(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuBuscarAgenciaPorNome);

        return menuAgencias;
    }
}
