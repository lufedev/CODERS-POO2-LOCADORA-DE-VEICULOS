package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;
import br.com.ada.grupo3.locadora.view.veiculo.MenuSair;

public class MenuAluguelFactory implements MenuFactory {

    private final AluguelManager gerenciadorDeAluguel;
    private final ClienteManager gerenciadorDeCliente;
    private final VeiculoManager gerenciadorDeVeiculo;
    private final AgenciaManager gerenciadorDeAgencia;

    public MenuAluguelFactory(AluguelManager gerenciadorDeAluguel, ClienteManager gerenciadorDeCliente, AgenciaManager gerenciadorDeAgencia, VeiculoManager gerenciadorDeVeiculo) {
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAlugueis = new MenuComSubmenus("Menu Alugueis");

        Menu menuAdicionarAluguel = new MenuAdicionarAluguel(gerenciadorDeAluguel, gerenciadorDeVeiculo);
        menuAlugueis.adicionarSubmenu(menuAdicionarAluguel);

        Menu menuBuscarAluguelPorNome = new MenuBuscarAluguelPorNome(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuBuscarAluguelPorNome);

        Menu menuFinalizarAluguel = new MenuFinalizarAluguel(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuFinalizarAluguel);

        Menu menuSair = new MenuSair();
        menuAlugueis.adicionarSubmenu(menuSair);


        return menuAlugueis;
    }
}
