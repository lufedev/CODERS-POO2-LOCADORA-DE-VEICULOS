package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

import java.util.List;

public class MenuBuscarClientePorNome extends MenuAbstrato {

    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;

    public MenuBuscarClientePorNome(ClienteManager gerenciadorDeCliente) {
        super("Buscar cliente por nome");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
    }

    @Override
    public void acao() {
        List<Cliente> listaCliente = gerenciadorDeCliente.buscarPeloNome(mensagens.nome()).stream().toList();
        if (listaCliente.isEmpty()) System.out.println(mensagens.falhaOperacao() + mensagens.clienteInexistente());
        else listaCliente.forEach(System.out::println);
    }
}
