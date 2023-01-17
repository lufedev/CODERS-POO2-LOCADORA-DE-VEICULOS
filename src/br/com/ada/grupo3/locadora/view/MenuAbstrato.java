package br.com.ada.grupo3.locadora.view;

public abstract class MenuAbstrato implements Menu {

    private final String descricao;

    public MenuAbstrato(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void exibir() {
        System.out.println(descricao);
    }

    @Override
    public void agir() {
        exibirComSeparador();
        acao();
    }

    protected abstract void acao();

    private void exibirComSeparador() {
        exibirSeparador();
        exibir();
        exibirSeparador();
    }

    private void exibirSeparador() {
        System.out.println("------------------------------------------");
    }
}
