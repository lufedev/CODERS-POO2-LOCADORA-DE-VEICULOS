package br.com.ada.grupo3.locadora.view.cliente;

import br.com.ada.grupo3.locadora.Util.ConsoleUIHelper;

public class Mensagens {
    public int pessoaFisicaOuJuridica(){
        return ConsoleUIHelper.askChooseOption(
                "O cliente a ser cadastrada é uma pessoa física ou jurídica? ", "Pessoa Física", "Pessoa Jurídica");
    }
    public String nome() {
        return ConsoleUIHelper.askSimpleInput("Digite o nome: ");
    }
    public String documento(){
        return ConsoleUIHelper.askSimpleInput("Digite o documento: ");
    }
    public String logradouro(){
        return ConsoleUIHelper.askSimpleInput("Digite o Logradouro: ");
    }
    public String numeroEndereco(){
        return ConsoleUIHelper.askSimpleInput("Digite o numero do endereço: ");
    }
    public  String cep(){
        return ConsoleUIHelper.askSimpleInput("Digite o cep: ");
    }
    public String cidade(){
        return ConsoleUIHelper.askSimpleInput("Digite a cidade: ");
    }
    public String ddi(){
        return ConsoleUIHelper.askSimpleInput("Digite o DDI do telefone: ");
    }

    public String ddd(){
        return ConsoleUIHelper.askSimpleInput("Digite o DDD do telefone: ");
    }
    public String numeroTelefone(){
       return  ConsoleUIHelper.askSimpleInput("Digite o numero do telefone: ");
    }
    public String email(){
        return ConsoleUIHelper.askSimpleInput("Digite o email: ");
    }
   public int menuAlterar() {
       return ConsoleUIHelper.askChooseOption("O que deseja alterar?", "Nome ", "documento", "E-mail", "Telefone", "Endereço");
   }
   public String valorInvalido(){
        return "Valor digitado invalido";
   }

   public String operacaoSucesso(){
        return "Operação realizada com sucesso";
   }
   public boolean tipoCadastro(){
        return ConsoleUIHelper.askConfirm(
                "Deseja fazer o cadastro completo ou cadastro rapido?",
                "Sim, quero fazer o cadastro rapido", "Não, quero fazer cadastro completo");
    }
    public String falhaOperacao(){
        return "Falha na operação";
    }
    public String listaVazia(){
        return "Lista vazia";
    }

}
