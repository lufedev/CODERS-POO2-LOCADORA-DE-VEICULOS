package br.com.ada.LocateCar.Clientes;
import br.com.ada.LocateCar.ConsoleUIHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ClientesRepositorio<E> implements ClintesRepositorioInterface {

    private List <Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(this.clientes);
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void cadastrarCliente() {
        int resposta = ConsoleUIHelper.askChooseOption(
        "O cliente a ser cadastrado é uma pessoa física ou jurídica? ", "Pessoa Física", "Pessoa Jurídica");
        long id = ThreadLocalRandom.current().nextInt(0, 999999);
        boolean continuar = true;
        do {
            if (!this.getClientes().contains(id)) continuar = false;
            else id = ThreadLocalRandom.current().nextInt(0, 9_999_999);
        }while(continuar);
        if (resposta == 1){
          cadastrarPessoaFisica(id);
        }else if (resposta == 2) {
            cadastrarPessoaJuridica(id);
        } else System.out.println("Valor digitado invalido");
    }

    private void cadastrarPessoaFisica(long id){
        ConsoleUIHelper.drawHeader("CADASTRO PESSOA FÍSICA", 100);
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome completo: ");
        String cpf = ConsoleUIHelper.askSimpleInput("Digite o CPF: ");
        String cnh = ConsoleUIHelper.askSimpleInput("Digite a CNH: ");
        PessoaFisica pessoaFisica = new PessoaFisica(id, cpf, cnh, nome);
        boolean infoExtras = ConsoleUIHelper.askConfirm("Deseja adicionar mais informações?", "Sim", "Não");
        if (infoExtras) {
            List<E> infosExtras = cadastrarInfosExtras();
            pessoaFisica.setEndereco((Endereco) infosExtras.get(0));
            pessoaFisica.setTelefone((Telefone) infosExtras.get(1));
            pessoaFisica.setEmail((String) infosExtras.get(2));
        }
        if (!this.getClientes().stream().anyMatch(cliente ->
                cliente.equals(pessoaFisica))) this.clientes.add(pessoaFisica);
        else System.out.println("Não é possivel adicionar um cliente já existentes/duplicados,"
                + " tente novamente com outras informações.");
    }
    private void cadastrarPessoaJuridica(long id) {
        ConsoleUIHelper.drawHeader("CADASTRO PESSOA JURÍDICA", 100);
        String nomeFantasia = ConsoleUIHelper.askSimpleInput("Digite o nome fantasia: ");
        String razaoSocial = ConsoleUIHelper.askSimpleInput("Digite a razão social: ");
        String cnpj = ConsoleUIHelper.askSimpleInput("Digite o cnpj: ");
        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, cnpj, razaoSocial, nomeFantasia);
        boolean infoExtras = ConsoleUIHelper.askConfirm("Deseja adicionar mais informações?", "Sim", "Não");
        if (infoExtras) {
           List<E> infosExtras = cadastrarInfosExtras();
           pessoaJuridica.setEndereco((Endereco) infosExtras.get(0));
           pessoaJuridica.setTelefone((Telefone) infosExtras.get(1));
           pessoaJuridica.setEmail((String) infosExtras.get(2));
        }
        if (!this.getClientes().stream().anyMatch(cliente -> cliente.equals(pessoaJuridica))) this.clientes.add(pessoaJuridica);
        else System.out.println("Não é possivel adicionar um cliente já existentes/duplicados," + " tente novamente com outras informações.");
    }
    private List<E> cadastrarInfosExtras(){
        Endereco end = cadastrarEndereco();
        Telefone tel = cadastrarTelefone();
        String email = cadastrarEmail();
        return (List<E>) List.of (end, tel, email);
    }
    private Endereco cadastrarEndereco() {
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite o Logradouro: ");
        String numEnd = ConsoleUIHelper.askSimpleInput("Digite o numero do endereço: ");
        String complemento = ConsoleUIHelper.askSimpleInput("Digite o complemento: ");
        String bairro = ConsoleUIHelper.askSimpleInput("Digite o bairro: ");
        String cep = ConsoleUIHelper.askSimpleInput("Digite o cep: ");
        String cidade = ConsoleUIHelper.askSimpleInput("Digite a cidade: ");
        String uf = ConsoleUIHelper.askSimpleInput("Digite o Estado(UF): ");
        return new Endereco(logradouro, bairro, numEnd, complemento,cep,cidade, uf);
    }

    private Telefone cadastrarTelefone(){
        String ddi = ConsoleUIHelper.askSimpleInput("Digite o DDI do telefone: ");
        String ddd = ConsoleUIHelper.askSimpleInput("Digite o DDD do telefone: ");
        String numTel = ConsoleUIHelper.askSimpleInput("Digite o numero do telefone: ");
        return  new Telefone(ddi, ddd, numTel);
    }
    private String cadastrarEmail(){
        return ConsoleUIHelper.askSimpleInput("Digite o email: ");
    }

    @Override
    public void alterarCliente() {
        if (!getClientes().isEmpty()) {
            int resposta = ConsoleUIHelper.askChooseOption(
                "O cliente a ser alterado é uma pessoa física ou jurídica? ",
                "Pessoa Física", "Pessoa Jurídica");
            int  indice = getIndice();
            if (resposta == 1) alterarPessoaFisica(indice);
            else if (resposta == 2) alterarPessoaJuridica(indice);
            else System.out.println("Id nao encontrado");
        }else System.out.println("Lista de clientes vazia");
    }

    private void alterarPessoaFisica(int indice){
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?",
                "Nome Completo", "CNH", "CPF", "E-mail", "Telefone", "Endereço"));
        switch (escolha) {
            case "1":
                ((PessoaFisica) this.clientes.get(indice)).setNome(ConsoleUIHelper.askSimpleInput("Digite o nome completo: "));break;
            case "2":
                ((PessoaFisica) this.clientes.get(indice)).setCnh(ConsoleUIHelper.askSimpleInput("Digite a CNH: "));break;
            case "3":
                ((PessoaFisica) this.clientes.get(indice)).setCpf(ConsoleUIHelper.askSimpleInput("Digite o CPF: "));break;
            case "4":
                String email = cadastrarEmail();
                this.clientes.get(indice).setEmail(email);break;
            case "5":
                Telefone tel = cadastrarTelefone();
                this.clientes.get(indice).setTelefone(tel);break;
            case "6":
                Endereco end = cadastrarEndereco();
                this.clientes.get(indice).setEndereco(end);break;
            default:
                System.out.println("Valor digitado invalido");
        }
    }
    private void alterarPessoaJuridica(int indice) {
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?",
                "Nome Fantasia", "Razão Social", "CNPJ", "E-mail", "Telefone", "Endereço"));
        switch (escolha) {
            case "1":
                ((PessoaJuridica) this.clientes.get(indice)).setNomeFantasia(ConsoleUIHelper.askSimpleInput("Digite o nome fantasia: "));break;
            case "2":
                ((PessoaJuridica) this.clientes.get(indice)).setRazaoSocial(ConsoleUIHelper.askSimpleInput("Digite a razão social: "));break;
            case "3":
                ((PessoaJuridica) this.clientes.get(indice)).setCnpj(ConsoleUIHelper.askSimpleInput("Digite o CNPJ: "));break;
            case "4":
                String email = cadastrarEmail();
                this.clientes.get(indice).setEmail(email);break;
            case "5":
                Telefone tel = cadastrarTelefone();
                this.clientes.get(indice).setTelefone(tel);break;
            case "6":
                Endereco end = cadastrarEndereco();
                this.clientes.get(indice).setEndereco(end);break;
            default:
                System.out.println("Valor digitado invalido");
        }
    }

    @Override
    public void removerCliente() {
        if (!clientes.isEmpty()) {
                int indice = getIndice();
                System.out.println("Voce selecionou o cliente " + getClientes().get(indice));
               if (ConsoleUIHelper.askConfirm(String.format(
                               "Deseja remover o cliente com id %d?", getClientes().get(indice).getId()),
                       "Sim", "Não")) {
                   this.clientes.remove(indice);
                   System.out.println("Cliente removido com sucesso");
               }else System.out.println("Cliente nao foi removido do banco de dados");
        }else System.out.println("Sem clientes cadastrados");
    }

    @Override
    public void buscarCliente() {
        if (!clientes.isEmpty()) {
            int resposta = ConsoleUIHelper.askChooseOption(
                    "O cliente a ser pesquisado é uma pessoa física ou jurídica? ",
                    "Pessoa Física", "Pessoa Jurídica");
            if (resposta == 1) buscarPessoaFisica();
            else if (resposta == 2)buscarPessoaJuridica();
            else System.out.println("Valor digitado invalido");
            }
        }
    private void buscarPessoaFisica() {
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("Como deseja fazer a busca?",
                "Nome Completo", "CPF"));
        String tipoCliente = "PessoaFisica";
        switch (escolha) {
            case "1":
                String busca = ConsoleUIHelper.askSimpleInput("Digite o nome do cliente para pesquisa:");
                busca(busca, escolha, tipoCliente);break;
            case "2":
                busca = ConsoleUIHelper.askSimpleInput("Digite o CPF do cliente para pesquisa:");
                busca(busca, escolha, tipoCliente);break;
            default:
                System.out.println("Digite um valor valido!");
        }
    }
    private void buscarPessoaJuridica() {
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("Como deseja fazer a busca?",
                "Nome Fantasia", "CNPJ"));
        String tipoCliente = "PessoaJuridica";
        switch (escolha) {
            case "1":
                String busca = ConsoleUIHelper.askSimpleInput("Digite o nome fantasia do cliente para pesquisa:");
               busca(busca, escolha, tipoCliente);break;
            case "2":
                busca = ConsoleUIHelper.askSimpleInput("Digite o CNPJ do cliente para pesquisa:");
                busca(busca, escolha, tipoCliente);break;

            default:
                System.out.println("Digite um valor valido!");
        }
    }

    private void busca(String busca, String escolha, String tipoCliente) {
        int contador = 0;
        int tamanho = busca.length();
        String pesquisa;
        for (int i = 0; i < getClientes().size(); i++) {

            if (this.clientes.get(i).getClass().equals(PessoaFisica.class)) {
                if (escolha.equals("1")) pesquisa = ((PessoaFisica) this.clientes.get(i)).getNome();
                else pesquisa = ((PessoaFisica) this.clientes.get(i)).getCpf();

        }else {
                if (escolha.equals("1")) pesquisa = ((PessoaJuridica) this.clientes.get(i)).getNomeFantasia();
                else pesquisa = ((PessoaJuridica) this.clientes.get(i)).getCnpj();
            }

            if (busca.length() <= pesquisa.length()) {
                if (busca.equalsIgnoreCase(pesquisa.substring(0, tamanho))) {
                    System.out.print(getClientes().get(i).toString() + "\n");
                    System.out.println();
                } else contador++;
            }
        }
        if (contador == getClientes().size()) {
            System.out.println("Cliente não encontrado!");
            System.out.println();
        }
    }

    public int getIndice() {
        int indice = -9;
        Integer id = Integer.parseInt(ConsoleUIHelper.askSimpleInput("Digite o ID do cliente: "));
            for (int i = 0; i < getClientes().size(); i++) {
                if (id == (getClientes().get(i).getId())) {
                    indice = i;
                }
            }
            if (indice >= 0) System.out.println(getClientes().get(indice));
            else System.out.println("ID não encontrado");
        return indice;
    }
    public void listarClientes(){
        System.out.println(getClientes().toString());
    }
}