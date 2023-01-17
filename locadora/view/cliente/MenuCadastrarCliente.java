package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuCadastrarCliente extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;
    public MenuCadastrarCliente(ClienteManager gerenciadorDeCliente) {
        super("Adicionar cliente");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }

    @Override
    public void acao() {
        gerenciadorDeCliente.menuClienteCadastrar();
    }
}
