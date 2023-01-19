package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.MenuVolta;

public class MenuAgenciaFactory implements MenuFactory {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuAgenciaFactory(AgenciaManager gerenciadorDeAgencia) {
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAgencias = new MenuComSubmenus("Menu Agencias");

        Menu menuAdicionarAgencia = new MenuCadastrarAgencia(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuAdicionarAgencia);

        Menu menuRemoverAgencia = new MenuRemoverAgencia(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuRemoverAgencia);

        Menu menuAlterarAgencia = new MenuAlterarAgencia(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuAlterarAgencia);

        Menu menuBuscarAgenciaPorNome = new MenuBuscarAgenciaPorNome(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuBuscarAgenciaPorNome);

        Menu menuListarAgencias = new MenuListarAgencias(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuListarAgencias);

        Menu menuVolta = new MenuVolta();
        menuAgencias.adicionarSubmenu(menuVolta);

        return menuAgencias;
    }
}
