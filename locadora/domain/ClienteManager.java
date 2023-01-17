package br.com.ada.grupo3.locadora.domain;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.model.Telefone;
import br.com.ada.grupo3.locadora.model.TipoCliente;
import br.com.ada.grupo3.locadora.persistence.ClienteEmMemoriaRepository;
import br.com.ada.grupo3.locadora.view.cliente.Mensagens;
import java.math.BigDecimal;
import java.util.List;

public class ClienteManager extends ClienteEmMemoriaRepository {

    private final Mensagens mensagens;
    private final ClienteEmMemoriaRepository clienteEmMemoriaRepository;

    public ClienteManager() {
        this.mensagens = new Mensagens();
        this.clienteEmMemoriaRepository = new ClienteEmMemoriaRepository();
    }

    public Cliente alterarCliente(Cliente cliente) {
        alterarInfos(cliente);
        return cliente;
    }

    public Cliente cadastrarCliente(boolean cadastroCompleto) {
        Cliente cliente = new Cliente();
        cliente.setTipoCliente(cadastrarTipoCliente());
        List<String> nomeDoc = cadastrarNomeEDocumento();
        cliente.setNome(nomeDoc.get(0));
        cliente.setDocumento(nomeDoc.get(1));
        if (!cadastroCompleto) {
            cliente.setEmail(cadastrarEmail());
            cliente.setTelefone(cadastrarTelefone());
            cliente.setEndenreco(cadastrarEndereco());
        }
        return cliente;
    }

    private void alterarInfos(Cliente cliente) {
        String escolha = Integer.toString(mensagens.menuAlterar());
        switch (escolha) {
            case "1" -> cliente.setNome(mensagens.nome());
            case "2" -> cliente.setDocumento(mensagens.documento());
            case "3" -> cliente.setEmail(cadastrarEmail());
            case "4" -> cliente.setTelefone(cadastrarTelefone());
            case "5" -> cliente.setEndenreco(cadastrarEndereco());
            default -> System.out.println(mensagens.valorInvalido());
        }
    }

    private TipoCliente cadastrarTipoCliente() {
        int resposta = -9;
        do {
            resposta = mensagens.pessoaFisicaOuJuridica();
        }while(resposta <0 && resposta > 3);
        return (resposta == 1) ?
                new TipoCliente("Pessoa Fisica", BigDecimal.valueOf(5), 5) :
                new TipoCliente("Pessoa Juridica", BigDecimal.valueOf(10), 3);
    }

    private List<String> cadastrarNomeEDocumento() {
        String nome = mensagens.nome();
        String doc = mensagens.documento();
        return List.of(nome, doc);
    }

    private Endereco cadastrarEndereco() {
        String logradouro = mensagens.logradouro();
        String numEnd = mensagens.numeroEndereco();
        String cep = mensagens.cep();
        String cidade = mensagens.cidade();
        return new Endereco(logradouro, numEnd, cep, cidade);
    }

    private Telefone cadastrarTelefone() {
        String ddi = mensagens.ddi();
        String ddd = mensagens.ddd();
        String numTel = mensagens.numeroTelefone();
        return new Telefone(ddi, ddd, numTel);
    }
    private String cadastrarEmail() {
        return mensagens.email();
    }

    public void menuClienteRemover(){
            if (!clienteEmMemoriaRepository.getEntidades().isEmpty()) {
                int listaSize = clienteEmMemoriaRepository.getEntidades().size();
                String id = mensagens.documento();
                Cliente cl = clienteEmMemoriaRepository.buscarPeloId(id);
                try {
                    clienteEmMemoriaRepository.remover(cl);
                }catch (NullPointerException e){
                    System.err.println(mensagens.falhaOperacao());
                }
                if (listaSize > clienteEmMemoriaRepository.getEntidades().size()) System.out.println(mensagens.operacaoSucesso());
                else System.out.println(mensagens.falhaOperacao());
            } else System.out.println(mensagens.listaVazia());
    }

    public void menuClienteAlterar(){
        if (!clienteEmMemoriaRepository.getEntidades().isEmpty()) {
            String id = mensagens.documento();
            Cliente cliente = clienteEmMemoriaRepository.getEntidades().get(id);
            try {
                clienteEmMemoriaRepository.salvar(alterarCliente(cliente));
                System.out.println(mensagens.operacaoSucesso());
            }catch (NullPointerException e){
                System.err.println(mensagens.falhaOperacao());
            }
        } else System.out.println(mensagens.listaVazia());
    }

    public void menuClienteBuscarNome(){
        if (!clienteEmMemoriaRepository.getEntidades().isEmpty()) {
            clienteEmMemoriaRepository.buscarPeloNome(mensagens.nome()).forEach(System.out::println);
        } else System.out.println(mensagens.listaVazia());
    }

    public void menuClienteBusarId(){
        if (!clienteEmMemoriaRepository.getEntidades().isEmpty()) {
            String id = mensagens.documento();
            Cliente cliente = clienteEmMemoriaRepository.buscarPeloId(id);
            if (cliente==null) System.out.println(mensagens.falhaOperacao());
            else System.out.println(cliente);
        } else System.out.println(mensagens.listaVazia());
    }
    public void menuClienteCadastrar(){
        int listaSize = clienteEmMemoriaRepository.getEntidades().size();
        clienteEmMemoriaRepository.salvar(cadastrarCliente(mensagens.tipoCadastro()));
        if (listaSize == clienteEmMemoriaRepository.getEntidades().size()) {
            System.out.println(mensagens.falhaOperacao());
        } else System.out.println(mensagens.operacaoSucesso());

    }
//    public void listarClientes(){
//        System.out.println(clienteEmMemoriaRepository.getEntidades());
//    }
}
