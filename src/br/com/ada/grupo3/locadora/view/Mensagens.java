package br.com.ada.grupo3.locadora.view;

import br.com.ada.grupo3.locadora.util.ConsoleUIHelper;

public class Mensagens {
    public int pessoaFisicaOuJuridica(){
        return ConsoleUIHelper.askChooseOption(
                "O cliente a ser cadastrada é uma pessoa física ou jurídica? ", "Pessoa Física", "Pessoa Jurídica");
    }
    public String nome() {
        return ConsoleUIHelper.askSimpleInput("Digite o nome do cliente: ");
    }
    public String documento(){
        return ConsoleUIHelper.askSimpleInput("Digite o documento do cliente: ");
    }
    public String endereco(){return ConsoleUIHelper.askSimpleInput("Digite o endereço: ");}
    public String telefone() {return ConsoleUIHelper.askSimpleInput("Digite o numero do telefone: ");}
    public String email(){
        return ConsoleUIHelper.askSimpleInput("Digite o email: ");
    }
    public int menuAlterar() {
        return ConsoleUIHelper.askChooseOption("O que deseja alterar?", "Nome ", "E-mail", "Telefone", "Endereço");
    }
    public String valorInvalido(){
        return "Valor digitado invalido. ";
    }

    public String operacaoSucesso(){
        return "Operação realizada com sucesso. ";
    }
    public String falhaOperacao(){
        return "Falha na operação. ";
    }
    public String listaVazia(){
        return "Lista vazia. ";
    }

    public String clienteInexistente() {
        return "Cliente inexiste. ";
    }

    public String clienteAlterado() {
        return "Cliente alterado. ";
    }

    public String clienteCadastrado() {
        return "Cliente cadastrado. ";
    }

    public String tenteNovamente() {
        return "Tente novamente. ";
    }

    public String clienteRemovido() {
        return "Cliente removido. ";
    }
}
