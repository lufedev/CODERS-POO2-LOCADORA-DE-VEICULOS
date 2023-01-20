package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MenuListarClientes extends MenuAbstrato {
    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;

    public MenuListarClientes(ClienteManager gerenciadorDeCliente) {
        super("Listar clientes cadastrados");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
    }

    @Override
    protected void acao() {
        List<Cliente> clientes = new ArrayList<>(gerenciadorDeCliente.getEntidades().values());


        if (clientes.isEmpty()) {
            System.out.println(mensagens.listaClientesVazia());
            return;
        }

        listarClientes(clientes);
    }

    public void listarClientes(List<Cliente> clientes) {
        clientes.forEach(System.out::println);
        PaginacaoListas.listarEmPaginas(clientes, "Lista de clientes encontrados");
    }

}