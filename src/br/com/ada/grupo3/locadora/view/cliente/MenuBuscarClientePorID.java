package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuBuscarClientePorID extends MenuAbstrato {
    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;
    public MenuBuscarClientePorID(ClienteManager gerenciadorDeCliente) {
        super("Buscar cliente por ID(Documento)");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
    }

    @Override
    protected void acao() {
        String id = mensagens.documento();
        Cliente cliente = gerenciadorDeCliente.buscarPeloId(id);
        if (cliente==null) System.out.println(mensagens.falhaOperacao() + mensagens.clienteInexistente());
        else System.out.println(cliente);
    }
}
