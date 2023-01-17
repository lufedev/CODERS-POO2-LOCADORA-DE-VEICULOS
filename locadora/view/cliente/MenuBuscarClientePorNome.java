package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuBuscarClientePorNome extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;

    public MenuBuscarClientePorNome(ClienteManager gerenciadorDeCliente) {
        super("Buscar cliente por nome");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        gerenciadorDeCliente.menuClienteBuscarNome();
    }
}
