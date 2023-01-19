package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuRemoverCliente extends MenuAbstrato {
    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;

    public MenuRemoverCliente(ClienteManager gerenciadorDeCliente) {
        super("Remover cliente");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
    }

    @Override
    protected void acao() {
        Cliente cliente = gerenciadorDeCliente.buscarPeloId(mensagens.documento());
        if (gerenciadorDeCliente.getEntidades().containsValue(cliente)){
            gerenciadorDeCliente.remover(cliente);
            System.out.println(mensagens.operacaoSucesso() + mensagens.clienteRemovido());

        } else {
            System.out.println(mensagens.falhaOperacao() + mensagens.clienteInexistente());
        }
    }
}
