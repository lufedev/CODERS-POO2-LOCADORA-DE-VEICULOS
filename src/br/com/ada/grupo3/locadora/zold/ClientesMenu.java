package br.com.ada.grupo3.locadora.zold;

import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.persistence.ClienteRepositoryInMemory;

public class ClientesMenu {

    public void menuClientes() {
        ClienteRepositoryInMemory clienteRepositoryInMemory = new ClienteRepositoryInMemory();
        boolean flag = false, continuar;
        do {
            ConsoleUIHelper.drawHeader("MENU CLIENTES", 100);
            String id;
            int listaSize = clienteRepositoryInMemory.getEntidades().size();
            String menu = Integer.toString(ConsoleUIHelper.askChooseOption("Escolha um numero do indice:", "Cadastrar novo cliente", "Buscar cliente por documento", "Buscar cliente por nome", "Alterar cliente", "Remover cliente", "Sair do menu de clientes"));
            switch (menu) {
                case "1" -> {
                    do {
                        Cliente cliente = clienteRepositoryInMemory.cadastrarCliente(ConsoleUIHelper.askConfirm("Deseja fazer o cadastro completo do cliente ou cadastro rapido?", "Sim, quero fazer o cadastro completo", "Não, quero fazer cadastro simples"));
                        clienteRepositoryInMemory.salvar(cliente);
                        if (listaSize == clienteRepositoryInMemory.getEntidades().size()) {
                            System.out.println("falha ao cadastrar novo cliente, documentos deste cliente ja esta cadastrado no sistema.");
                        } else System.out.println("Cliente cadastrado com sucesso");
                        continuar = ConsoleUIHelper.askConfirm("Deseja continuar cadastrando clientes?", "Sim", "Não");
                    } while (continuar);
                }
                case "2" -> {
                    do {
                        if (!clienteRepositoryInMemory.getEntidades().isEmpty()) {
                            id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                            try {
                                clienteRepositoryInMemory.buscarPeloId(id);
                            } catch (NullPointerException e) {
                                System.out.println("Cliente nao encontrado");
                            }
                        } else System.out.println("lista de clientes esta vazia");
                        continuar = ConsoleUIHelper.askConfirm("Deseja fazer outra pesquisa por documento?", "Sim", "Não");
                    } while (continuar);
                }
                case "3" -> {
                    do {
                        if (!clienteRepositoryInMemory.getEntidades().isEmpty()) {
                            clienteRepositoryInMemory.buscarPeloNome(ConsoleUIHelper.askSimpleInput("Digite o nome ou parte do nome para fazer a busca:")).forEach(System.out::println);
                        } else System.out.println("lista de clientes esta vazia");
                        continuar = ConsoleUIHelper.askConfirm("Deseja fazer outra pesquisa pelo nome?", "Sim", "Não");
                    } while (continuar);
                }
                case "4" -> {
                    do {
                        if (!clienteRepositoryInMemory.getEntidades().isEmpty()) {
                            id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                            clienteRepositoryInMemory.alterarCliente(id);
                            System.out.println("Cliente alterado com sucesso");
                        } else System.out.println("lista de clientes esta vazia");
                        continuar = ConsoleUIHelper.askConfirm("Deseja continuar alternado informações dos clientes?", "Sim", "Não");
                    } while (continuar);
                }
                case "5" -> {
                    do {
                        if (!clienteRepositoryInMemory.getEntidades().isEmpty()) {
                            id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                            Cliente cl = clienteRepositoryInMemory.buscarPeloId(id);
                            clienteRepositoryInMemory.remover(cl);
                            if (listaSize > clienteRepositoryInMemory.getEntidades().size())
                                System.out.println("Cliente removido com sucesso");
                            else System.out.println("Nao foi possivel remover cliente");
                        } else System.out.println("lista de clientes esta vazia");
                        continuar = ConsoleUIHelper.askConfirm("Deseja continuar removendo clientes?", "Sim", "Não");
                    } while (continuar);
                }
                case "6" -> {
                    flag = ConsoleUIHelper.askConfirm("Deseja mesmo sair do menu de clientes?", "Sim", "Não");
                    System.out.println("Saindo do menu de clientes");
                }
                default -> System.out.println("Digite um valor valido para o menu");
            }
        } while (!flag);
    }
}
