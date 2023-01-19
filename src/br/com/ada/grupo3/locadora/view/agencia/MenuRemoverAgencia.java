package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuRemoverAgencia extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuRemoverAgencia(AgenciaManager gerenciadorDeAgencia) {
        super("Remover agência");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da agência a ser removida");

        while (!gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Não existe uma agência com o nome " + nome);
            nome = CapturadorDeEntrada.capturarString("nome da agência a ser removida ou <0> para cancelar operacao");
            if (nome.equals("0")) return;
        }

        Agencia agencia = gerenciadorDeAgencia.buscarAgenciaPorNome(nome);

        gerenciadorDeAgencia.removerAgencia(agencia);

        System.out.printf("Agência %s removida com sucesso%n", nome);
    }
}
