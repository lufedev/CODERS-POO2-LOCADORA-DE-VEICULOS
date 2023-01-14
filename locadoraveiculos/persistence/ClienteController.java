package br.com.ada.projeto.locadoraveiculos.persistence;

import br.com.ada.projeto.locadoraveiculos.ConsoleUIHelper;
import br.com.ada.projeto.locadoraveiculos.model.Cliente;
import br.com.ada.projeto.locadoraveiculos.model.Endereco;
import br.com.ada.projeto.locadoraveiculos.model.Telefone;
import br.com.ada.projeto.locadoraveiculos.model.TipoCliente;

import java.math.BigDecimal;
import java.util.List;

public class ClienteController extends ClienteEmMemoriaRepository{
    protected static void alterarInfos(Cliente cliente){
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?",
                "Nome ", "documento", "E-mail", "Telefone", "Endereço"));
        switch (escolha) {
            case "1":
                cliente.setNome(ConsoleUIHelper.askSimpleInput("Digite o nome: "));break;
            case "2":
                cliente.setDocumento(ConsoleUIHelper.askSimpleInput("Digite o documento: "));break;
            case "3":
                cliente.setEmail(cadastrarEmail());break;
            case "4":
                cliente.setTelefone(cadastrarTelefone());break;
            case "5":
                cliente.setEndenreco(cadastrarEndereco());break;
            default:
                System.out.println("Valor digitado invalido");
        }
    }
    protected static TipoCliente cadastrarTipoCliente(){
        int resposta = ConsoleUIHelper.askChooseOption(
                "O cliente a ser cadastrada é uma pessoa física ou jurídica? ", "Pessoa Física", "Pessoa Jurídica");
        TipoCliente tipoCliente = (resposta == 1) ?
                new TipoCliente("Pessoa Fisica", BigDecimal.valueOf(5), 5) :
                new TipoCliente("Pessoa Juridica", BigDecimal.valueOf(10), 3);
        return tipoCliente;
    }
    protected static List<String> cadastrarNomeEDocumento(){
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome: ");
        String doc = ConsoleUIHelper.askSimpleInput("Digite o documento: ");
        return List.of(nome, doc);
    }
    protected static Cliente cadastrarInfosExtras(Cliente cliente){
        cliente.setEndenreco(cadastrarEndereco());
        cliente.setTelefone(cadastrarTelefone());
        cliente.setEmail(cadastrarEmail());
        return cliente;
    }
    private static Endereco cadastrarEndereco() {
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite o Logradouro: ");
        String numEnd = ConsoleUIHelper.askSimpleInput("Digite o numero do endereço: ");
        String complemento = ConsoleUIHelper.askSimpleInput("Digite o complemento: ");
        String bairro = ConsoleUIHelper.askSimpleInput("Digite o bairro: ");
        String cep = ConsoleUIHelper.askSimpleInput("Digite o cep: ");
        String cidade = ConsoleUIHelper.askSimpleInput("Digite a cidade: ");
        String uf = ConsoleUIHelper.askSimpleInput("Digite o Estado(UF): ");
        return new Endereco(logradouro, bairro, numEnd, complemento,cep,cidade, uf);
    }
    private static Telefone cadastrarTelefone(){
        String ddi = ConsoleUIHelper.askSimpleInput("Digite o DDI do telefone: ");
        String ddd = ConsoleUIHelper.askSimpleInput("Digite o DDD do telefone: ");
        String numTel = ConsoleUIHelper.askSimpleInput("Digite o numero do telefone: ");
        return  new Telefone(ddi, ddd, numTel);
    }
    private static String cadastrarEmail(){
        return ConsoleUIHelper.askSimpleInput("Digite o email: ");
    }
}
