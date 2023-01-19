package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.veiculo.MenuSair;

public class MenuAluguelFactory implements MenuFactory {

    private final AluguelManager gerenciadorDeAluguel;

    public MenuAluguelFactory(AluguelManager gerenciadorDeAluguel) {
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAlugueis = new MenuComSubmenus("Menu Alugueis");

        Menu menuAdicionarAluguel = new MenuAdicionarAluguel(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuAdicionarAluguel);

        Menu menuBuscarAluguelPorNome = new MenuBuscarAluguelPorNome(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuBuscarAluguelPorNome);

        Menu menuSair = new MenuSair();
        menuAlugueis.adicionarSubmenu(menuSair);


        return menuAlugueis;
    }
}
