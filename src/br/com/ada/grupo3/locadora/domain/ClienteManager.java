package br.com.ada.grupo3.locadora.domain;
import br.com.ada.grupo3.locadora.persistence.ClienteRepository;
import br.com.ada.grupo3.locadora.view.Mensagens;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.TipoCliente;
import br.com.ada.grupo3.locadora.persistence.ClienteRepositoryInMemory;

import java.math.BigDecimal;

public class ClienteManager extends ClienteRepositoryInMemory {

    private final ClienteRepository clienteRepository;
    private final Mensagens mensagens;

    public ClienteManager(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.mensagens = new Mensagens();
    }

    public Cliente cadastrarCliente() {
        TipoCliente tipoCliente = cadastrarTipoCliente();
        String nome = mensagens.nome();
        String documento = mensagens.documento();
        String email = mensagens.email();
        String telefone = mensagens.telefone();
        String endereco = mensagens.endereco();
        return new Cliente(nome, documento, tipoCliente, email, endereco, telefone);
    }

    public void alterarCliente(Cliente cliente) {
        String escolha = Integer.toString(mensagens.menuAlterar());
        switch (escolha) {
            case "1" -> cliente.setNome(mensagens.nome());
            case "2" -> cliente.setEmail(mensagens.email());
            case "3" -> cliente.setTelefone(mensagens.telefone());
            case "4" -> cliente.setEndereco(mensagens.endereco());
            default -> System.out.println(mensagens.valorInvalido());
        }
    }

    private TipoCliente cadastrarTipoCliente() {
        int resposta;
        boolean continuar;
        do {
            resposta = mensagens.pessoaFisicaOuJuridica();
            continuar = resposta < 1 || resposta > 2;
        } while (continuar);
        return (resposta == 1) ?
                new TipoCliente("Pessoa Fisica", BigDecimal.valueOf(5), 5) :
                new TipoCliente("Pessoa Juridica", BigDecimal.valueOf(10), 3);
    }

}
