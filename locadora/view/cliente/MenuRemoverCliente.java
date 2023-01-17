package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuRemoverCliente extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;

    public MenuRemoverCliente(ClienteManager gerenciadorDeCliente) {
        super("Remover cliente:");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    protected void acao() {
        gerenciadorDeCliente.menuClienteRemover();
    }
}
