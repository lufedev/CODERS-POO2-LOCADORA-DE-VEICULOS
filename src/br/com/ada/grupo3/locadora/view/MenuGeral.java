package br.com.ada.grupo3.locadora.view;

public class MenuGeral extends MenuComSubmenus {
    public MenuGeral(String descricao) {
        super(descricao);
    }

    @Override
    protected void acao() {
        super.acao();

        this.agir();
    }
}
