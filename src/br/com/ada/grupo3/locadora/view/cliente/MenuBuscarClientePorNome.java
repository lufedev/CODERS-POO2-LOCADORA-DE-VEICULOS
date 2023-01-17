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
//        String nome = CapturadorDeEntrada.capturarString("nome da cliente buscada");
//
//        if (!gerenciadorDeCliente.existeCliente(nome)) {
//            System.out.println("Não existe cliente com o nome " + nome);
//            return;
//        }
//
//        Cliente cliente = gerenciadorDeCliente.buscarClientePorNome(nome);
//        System.out.println("Cliente encontrada:");
//        System.out.println(cliente);
    }
}
