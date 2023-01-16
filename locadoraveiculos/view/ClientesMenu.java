package br.com.ada.projeto.locadoraveiculos.view;
import br.com.ada.projeto.locadoraveiculos.ConsoleUIHelper;
import br.com.ada.projeto.locadoraveiculos.model.Cliente;
import br.com.ada.projeto.locadoraveiculos.persistence.ClienteEmMemoriaRepository;
import java.util.Scanner;
public class ClientesMenu {

    public void menuClientes(Scanner sc) {
        ClienteEmMemoriaRepository cr = new ClienteEmMemoriaRepository();
        boolean flag = false, continuar = false;
        do {
            ConsoleUIHelper.drawHeader("MENU CLIENTES", 100);
            String id;
            int listaSize = cr.getEntidades().size();
           String menu =  Integer.toString(ConsoleUIHelper.askChooseOption("Escolha um numero do indice:",
                   "Cadastrar novo cliente", "Buscar cliente por documento", "Buscar cliente por nome",
                   "Alterar cliente", "Remover cliente", "Sair do menu de clientes"));
            switch (menu) {
                case "1":
                    do {
                        Cliente cliente = cr.cadastrarCliente(ConsoleUIHelper.askConfirm(
                                "Deseja fazer o cadastro completo do cliente ou cadastro rapido?",
                        "Sim, quero fazer o cadastro completo", "Não, quero fazer cadastro simples"));
                        cr.salvar(cliente);
                        if (listaSize == cr.getEntidades().size()) {
                            System.out.println("falha ao cadastrar novo cliente, documentos deste cliente ja esta cadastrado no sistema.");
                        } else System.out.println("Cliente cadastrado com sucesso");
                        continuar = ConsoleUIHelper.askConfirm("Deseja continuar cadastrando clientes?", "Sim", "Não");
                    }while (continuar);
                    break;

                case "2":
                    do{
                    if (!cr.getEntidades().isEmpty()) {
                        id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                        try{
                            cr.buscarPeloId(id);
                        }catch(NullPointerException e){
                            System.out.println("Cliente nao encontrado");
                        }
                    } else System.out.println("lista de clientes esta vazia");
                    continuar = ConsoleUIHelper.askConfirm("Deseja fazer outra pesquisa por documento?", "Sim", "Não");
            }while (continuar);
                    break;

                case "3":
                    do{
                    if (!cr.getEntidades().isEmpty()) {
                        cr.buscarPeloNome(ConsoleUIHelper.askSimpleInput(
                        "Digite o nome ou parte do nome para fazer a busca:")).forEach(System.out::println);
                    } else System.out.println("lista de clientes esta vazia");
                    continuar = ConsoleUIHelper.askConfirm("Deseja fazer outra pesquisa pelo nome?", "Sim", "Não");
                    }while (continuar);
                    break;

                case "4":
                    do{
                    if (!cr.getEntidades().isEmpty()) {
                        id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                        cr.alterarCliente(id);
                        System.out.println("Cliente alterado com sucesso");
                    } else System.out.println("lista de clientes esta vazia");
                    continuar = ConsoleUIHelper.askConfirm("Deseja continuar alternado informações dos clientes?", "Sim", "Não");
                    }while (continuar);
                    break;

                case "5":
                    do {
                    if (!cr.getEntidades().isEmpty()) {
                        id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                        Cliente cl = cr.buscarPeloId(id);
                        cr.remover(cl);
                        if (listaSize > cr.getEntidades().size()) System.out.println("Cliente removido com sucesso");
                        else System.out.println("Nao foi possivel remover cliente");
                    } else System.out.println("lista de clientes esta vazia");
                    continuar = ConsoleUIHelper.askConfirm("Deseja continuar removendo clientes?", "Sim", "Não");
                    }while (continuar);
                    break;
                case "6":
                    flag = ConsoleUIHelper.askConfirm("Deseja mesmo sair do menu de clientes?", "Sim", "Não");
                        System.out.println("Saindo do menu de clientes");break;
                default:
                    System.out.println("Digite um valor valido para o menu");break;

            }
        } while (!flag);
    }
}
