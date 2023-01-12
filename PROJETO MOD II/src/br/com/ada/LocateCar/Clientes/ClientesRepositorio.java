package br.com.ada.LocateCar.Clientes;
import br.com.ada.LocateCar.ConsoleUIHelper;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class ClientesRepositorio implements ClintesRepositorioInterface {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    @Override
    public void cadastrarCliente() {
        int resposta = ConsoleUIHelper.askChooseOption(
                "O cliente a ser cadastrado é uma pessoa física ou jurídica? ",
                "Pessoa Física", "Pessoa Jurídica");
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

    @Override
    public void alterarCliente() {
        if (!getClientes().isEmpty()) {
            int resposta = ConsoleUIHelper.askChooseOption(
                "O cliente a ser alterado é uma pessoa física ou jurídica? ",
                "Pessoa Física", "Pessoa Jurídica");
        //listarClientes(); ?
        int  indice = getIndice();
        if (resposta == 1) alterarPessoaFisica(indice);
        else if (resposta == 2) alterarPessoaJuridica(indice);

        else System.out.println("Id nao encontrado");
            }else System.out.println("Lista de clientes vazia");
        }



    @Override
    public void removerCliente() {
        if (!clientes.isEmpty()) {
                //listarClientes(); ?
                int indice = getIndice();
                System.out.println("Voce selecionou o cliente " + getClientes().get(indice));
                boolean remover = ConsoleUIHelper.askConfirm(String.format(
                        "Deseja remover o cliente com id %d?", getClientes().get(indice).getId()),
                        "Sim", "Não");
               if (remover) {
                   this.clientes.remove(indice);
                   System.out.println("Cliente removido com sucesso");
               }else System.out.println("Cliente nao foi removido do banco de dados");
        }else System.out.println("Sem clientes cadastrados");
    }

    @Override
    public void buscarCliente() {

    }
    public int getIndice() {
        int indice = 0;
        Integer id = Integer.parseInt(ConsoleUIHelper.askSimpleInput("Digite o ID do cliente: "));
        if (getClientes().contains(id)) {
            for (int i = 0; i < getClientes().size(); i++) {
                if (id.equals(getClientes().get(i).getId())) {
                    indice = i;
                }
            }
        }
        return indice;
    }
    private void cadastrarPessoaFisica(long id){
        ConsoleUIHelper.drawHeader("CADASTRO PESSOA FÍSICA", 100);
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome completo: ");
        String cpf = ConsoleUIHelper.askSimpleInput("Digite o CPF: ");
        String cnh = ConsoleUIHelper.askSimpleInput("Digite a CNH: ");
        String email = cadastrarEmail();
        Telefone tel = cadastrarTelefone();
        Endereco end = cadastrarEndereco();

        PessoaFisica pessoaFisica = new PessoaFisica(id, end, email, tel, cpf, cnh, nome);

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
        String email = cadastrarEmail();
        Telefone tel = cadastrarTelefone();
        Endereco end = cadastrarEndereco();

        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, end, email, tel, cnpj, razaoSocial, nomeFantasia);

        if (!this.getClientes().stream().anyMatch(cliente ->
                cliente.equals(pessoaJuridica))) this.clientes.add(pessoaJuridica);
        else System.out.println("Não é possivel adicionar um cliente já existentes/duplicados,"
                + " tente novamente com outras informações.");
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
    private void alterarPessoaFisica(int indice){
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?",
                "Nome Completo", "CNH", "CPF", "E-mail", "Telefone", "Endereço"));
        switch (escolha) {
            case "1":
                String nome = ConsoleUIHelper.askSimpleInput("Digite o nome completo: ");
                ((PessoaFisica) this.clientes.get(indice)).setNome(nome);break;
            case "2":
                String cnh = ConsoleUIHelper.askSimpleInput("Digite a CNH: ");
                ((PessoaFisica) this.clientes.get(indice)).setCnh(cnh);break;
            case "3":
                String cpf = ConsoleUIHelper.askSimpleInput("Digite o nome completo: ");
                ((PessoaFisica) this.clientes.get(indice)).setCpf(cpf);break;
            case "4":
                String email = cadastrarEmail();
                this.clientes.get(indice).setEmail(email);
                break;
            case "5":
                Telefone tel = cadastrarTelefone();
                this.clientes.get(indice).setTelefone(tel);
                break;
            case "6":
                Endereco end = cadastrarEndereco();
                this.clientes.get(indice).setEndereco(end);
                break;
            default:
                System.out.println("Valor digitado invalido");
        }
    }
    private void alterarPessoaJuridica(int indice) {
        String escolha = Integer.toString(ConsoleUIHelper.askChooseOption("O que deseja alterar?",
                "Nome Fantasia", "Razão Social", "CNPJ", "E-mail", "Telefone", "Endereço"));
        switch (escolha) {
            case "1":
                String nomeFantasia = ConsoleUIHelper.askSimpleInput("Digite o nome fantasia: ");
                ((PessoaJuridica) this.clientes.get(indice)).setNomeFantasia(nomeFantasia);
                break;
            case "2":
                String razaoSocial = ConsoleUIHelper.askSimpleInput("Digite a razão social: ");
                ((PessoaJuridica) this.clientes.get(indice)).setRazaoSocial(razaoSocial);
                break;
            case "3":
                String cnpj = ConsoleUIHelper.askSimpleInput("Digite o nome completo: ");
                ((PessoaJuridica) this.clientes.get(indice)).setCnpj(cnpj);
                break;
            case "4":
                String email = cadastrarEmail();
                this.clientes.get(indice).setEmail(email);
                break;
            case "5":
                Telefone tel = cadastrarTelefone();
                this.clientes.get(indice).setTelefone(tel);
                break;
            case "6":
               Endereco end = cadastrarEndereco();
                this.clientes.get(indice).setEndereco(end);
                break;
            default:
                System.out.println("Valor digitado invalido");
        }
    }
    //FIM DA CLASSE
}

