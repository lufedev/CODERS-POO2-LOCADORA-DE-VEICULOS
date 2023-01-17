package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuAlterarCliente extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;

    public MenuAlterarCliente(ClienteManager gerenciadorDeCliente) {
        super("Alterar cliente");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    protected void acao() {
        gerenciadorDeCliente.menuClienteAlterar();
    }
}
