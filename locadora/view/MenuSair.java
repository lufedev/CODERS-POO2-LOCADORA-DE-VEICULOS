package br.com.ada.grupo3.locadora.view;

public class MenuSair extends MenuAbstrato {

    public MenuSair() {
        super("Sair");
    }

    @Override
    public final void agir(){
        System.out.println("saindo do programa...");
        System.exit(0);
    }
    @Override
    public final void acao() {
    }
}
