package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuBuscarClientePorId extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;

    public MenuBuscarClientePorId(ClienteManager gerenciadorDeCliente) {
        super("Buscar cliente por ID(documento):");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    protected void acao() {
        gerenciadorDeCliente.menuClienteBusarId();
    }
}
