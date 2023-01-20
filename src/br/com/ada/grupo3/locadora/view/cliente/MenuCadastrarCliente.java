package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.ClienteUtilDataBase;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.persistence.ClienteRepository;
import br.com.ada.grupo3.locadora.persistence.ClienteRepositoryInMemory;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuCadastrarCliente extends MenuAbstrato {
    private final ClienteManager gerenciadorDeCliente;
    private final Mensagens mensagens;
//    private final ClienteRepositoryInMemory clienteRepository;

    public MenuCadastrarCliente(ClienteManager gerenciadorDeCliente) {
        super("Cadastrar novo cliente");
        this.gerenciadorDeCliente = gerenciadorDeCliente;
        this.mensagens = new Mensagens();
//        this.clienteRepository = new ClienteRepositoryInMemory();
    }

    @Override
    public void acao() {
        Cliente cliente = gerenciadorDeCliente.cadastrarCliente();
        if (gerenciadorDeCliente.getEntidades().get(cliente.getDocumento()) == null){
            gerenciadorDeCliente.salvar(cliente);
            ClienteUtilDataBase.saveClientesBkp(gerenciadorDeCliente);
            System.out.println(mensagens.operacaoSucesso() + mensagens.clienteCadastrado());
        }
        else{
            System.out.println(mensagens.falhaOperacao() + mensagens.tenteNovamente());
        }
    }

}
