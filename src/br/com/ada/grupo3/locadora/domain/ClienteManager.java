package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.persistence.ClienteRepository;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.Telefone;
import br.com.ada.grupo3.locadora.model.TipoCliente;
import br.com.ada.grupo3.locadora.persistence.ClienteRepositoryInMemory;

import java.math.BigDecimal;
import java.util.List;

public class ClienteManager extends ClienteRepositoryInMemory {

    public ClienteManager(ClienteRepository clienteRepository) {}
//
//    public static void alterarInfos(Cliente cliente) {
//        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?", "Nome ", "documento", "E-mail", "Telefone", "Endereço"));
//        switch (escolha) {
//            case "1" -> cliente.setNome(ConsoleUIHelper.askSimpleInput("Digite o nome: "));
//            case "2" -> cliente.setDocumento(ConsoleUIHelper.askSimpleInput("Digite o Documento: "));
//            case "3" -> cliente.setEmail(cadastrarEmail());
//            case "4" -> cliente.setTelefone(cadastrarTelefone());
//            case "5" -> cliente.setEndereco(cadastrarEndereco());
//            default -> System.out.println("Valor digitado invalido");
//        }
//    }
//
//    public static TipoCliente cadastrarTipoCliente() {
//        int resposta = ConsoleUIHelper.askChooseOption("O cliente a ser cadastrada é uma pessoa física ou jurídica? ", "Pessoa Física", "Pessoa Jurídica");
//        return (resposta == 1) ? new TipoCliente("Pessoa Fisica", BigDecimal.valueOf(5), 5) : new TipoCliente("Pessoa Juridica", BigDecimal.valueOf(10), 3);
//    }
//
//    public static List<String> cadastrarNomeEDocumento() {
//        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome: ");
//        String doc = ConsoleUIHelper.askSimpleInput("Digite o documento: ");
//        return List.of(nome, doc);
//    }
//
//    public static Cliente cadastrarInfosExtras(Cliente cliente) {
//        cliente.setEndereco(cadastrarEndereco());
//        cliente.setTelefone(cadastrarTelefone());
//        cliente.setEmail(cadastrarEmail());
//        return cliente;
//    }
//
//    private static Endereco cadastrarEndereco() {
//        String logradouro = ConsoleUIHelper.askSimpleInput("Digite o Logradouro: ");
//        Integer numEnd = ConsoleUIHelper.askInt("Digite o numero do endereço: ");
//        String cidade = ConsoleUIHelper.askSimpleInput("Digite a cidade: ");
//        String uf = ConsoleUIHelper.askSimpleInput("Digite o Estado(UF): ");
//        return new Endereco(logradouro, numEnd, cidade, uf);
//    }
//
//    private static Telefone cadastrarTelefone() {
//        String ddi = ConsoleUIHelper.askSimpleInput("Digite o DDI do telefone: ");
//        String ddd = ConsoleUIHelper.askSimpleInput("Digite o DDD do telefone: ");
//        String numTel = ConsoleUIHelper.askSimpleInput("Digite o numero do telefone: ");
//        return new Telefone(ddi, ddd, numTel);
//    }
//
//    private static String cadastrarEmail() {
//        return ConsoleUIHelper.askSimpleInput("Digite o email: ");
//    }
}
