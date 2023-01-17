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
//        String nome = CapturadorDeEntrada.capturarString("nome da nova cliente");
//
//        while (gerenciadorDeCliente.existeCliente(nome)) {
//            System.out.println("Já existe uma cliente com o nome " + nome);
//            nome = CapturadorDeEntrada.capturarString("nome da nova cliente");
//        }
//        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova cliente");
//        int numero = CapturadorDeEntrada.capturarInteger("número da nova cliente");
//        String cidade = CapturadorDeEntrada.capturarString("cidade da nova cliente");
//        String uf = CapturadorDeEntrada.capturarString("UF da nova cliente");
//        Cliente cliente = gerenciadorDeCliente.criarCliente(nome, new Endereco(logradouro, numero, cidade, uf));
//
//        System.out.println("Cliente adicionada com sucesso");
//        System.out.println("Nova Cliente:");
//        System.out.println(cliente);
    }
}
