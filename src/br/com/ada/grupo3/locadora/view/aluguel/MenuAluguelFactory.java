package br.com.ada.grupo3.locadora.view.aluguel;
import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.MenuVolta;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.view.Menu;
import br.com.ada.grupo3.locadora.view.MenuComSubmenus;
import br.com.ada.grupo3.locadora.view.MenuFactory;


public class MenuAluguelFactory implements MenuFactory {

    private final AluguelManager gerenciadorDeAluguel;
    private final ClienteManager gerenciadorDeCliente;
    private final VeiculoManager gerenciadorDeVeiculo;
    private final AgenciaManager gerenciadorDeAgencia;


    public MenuAluguelFactory(AluguelManager gerenciadorDeAluguel, ClienteManager gerenciadorDeCliente, AgenciaManager gerenciadorDeAgencia, VeiculoManager gerenciadorDeVeiculo) {

        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAlugueis = new MenuComSubmenus("Menu Alugueis");

        Menu menuAdicionarAluguel = new MenuAdicionarAluguel(gerenciadorDeAluguel,gerenciadorDeCliente, gerenciadorDeAgencia, gerenciadorDeVeiculo);
        menuAlugueis.adicionarSubmenu(menuAdicionarAluguel);

        Menu menuBuscarAluguelPorNome = new MenuBuscarAluguelPorNome(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuBuscarAluguelPorNome);

        Menu menuAlterarAgenciaAluguel = new MenuAlterarAgenciaAluguel(gerenciadorDeAluguel, gerenciadorDeAgencia);
        menuAlugueis.adicionarSubmenu(menuAlterarAgenciaAluguel);

        Menu menuFinalizarAluguel = new MenuFinalizarAluguel(gerenciadorDeAluguel, gerenciadorDeVeiculo);
        menuAlugueis.adicionarSubmenu(menuFinalizarAluguel);

        Menu menuAlugueisEmAberto = new MenuAlugueisEmAberto(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuAlugueisEmAberto);

        Menu menuListarAlugueis = new MenuListarAlugueis(gerenciadorDeAluguel);
        menuAlugueis.adicionarSubmenu(menuListarAlugueis);

        Menu menuVolta = new MenuVolta();
        menuAlugueis.adicionarSubmenu(menuVolta);


        return menuAlugueis;
    }
}
