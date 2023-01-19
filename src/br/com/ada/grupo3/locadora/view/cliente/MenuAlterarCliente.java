package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuAlterarCliente extends MenuAbstrato {
    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;

    public MenuAlterarCliente(ClienteManager gerenciadorDeCliente) {
        super("Alterar cliente");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
    }

    @Override
    protected void acao() {
        Cliente cliente = gerenciadorDeCliente.buscarPeloId( mensagens.documento());
        if (gerenciadorDeCliente.getEntidades().containsValue(cliente)){
            System.out.println(cliente);
            gerenciadorDeCliente.alterarCliente(cliente);
            System.out.println(mensagens.operacaoSucesso() + mensagens.clienteAlterado());

        }else {
            System.out.println(mensagens.falhaOperacao() + mensagens.clienteInexistente());
        }
    }
}
