package br.com.ada.grupo3.locadora.view;

public class MenuSair extends MenuAbstrato {

    public MenuSair() {
        super("Sair");
    }

    @Override
    public final void acao() {
        System.out.println("saindo do programa...");
        System.exit(0);
    }
}
