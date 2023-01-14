package br.com.ada.projeto.locadoraveiculos.view;
import br.com.ada.projeto.locadoraveiculos.ConsoleUIHelper;
import br.com.ada.projeto.locadoraveiculos.model.Cliente;
import br.com.ada.projeto.locadoraveiculos.persistence.ClienteEmMemoriaRepository;
import java.util.Scanner;
public class ClientesMenu {

    public void menuClientes(Scanner sc) {
        ClienteEmMemoriaRepository cr = new ClienteEmMemoriaRepository();
        boolean flag = false;
        do {
            ConsoleUIHelper.drawHeader("MENU CLIENTES", 100);
           String menu =  Integer.toString(ConsoleUIHelper.askChooseOption("Escolha um numero do indice:",
                   "Cadastrar novo cliente", "Buscar cliente por documento", "Buscar cliente por nome", "Alterar cliente", "Remover cliente"));
            switch (menu) {
                case "1":
                   Cliente cliente = cr.cadastrarCliente(ConsoleUIHelper.askConfirm("Deseja cadastrar mais informações do cliente?",
                           "Sim", "Não"));
                    cr.salvar(cliente);
                    break;
                case "2":
                    String id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                    System.out.println(cr.buscarPeloId(id));break;
                case "3":
                    System.out.println(cr.buscarPeloNome(ConsoleUIHelper.askSimpleInput("Digite o nome ou parte do nome para fazer a busca:")));break;//trocar

                case "4":
                    id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                    cr.alterarCliente(id);break;

                case "5":
                    id = ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
                    Cliente cl = cr.buscarPeloId(id);
                    cr.remover(cl);break;

                case "6":
                    flag = true; break;
                default:
                    System.out.println("erro");
            }
        } while (!flag);
    }
}
