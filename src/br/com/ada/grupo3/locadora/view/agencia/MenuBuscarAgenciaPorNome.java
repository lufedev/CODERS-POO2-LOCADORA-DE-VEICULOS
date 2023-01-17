package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuBuscarAgenciaPorNome extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuBuscarAgenciaPorNome(AgenciaManager gerenciadorDeAgencia) {
        super("Buscar agencia por nome");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da agencia buscada");

        if (!gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Não existe agencia com o nome " + nome);
            return;
        }

        Agencia agencia = gerenciadorDeAgencia.buscarAgenciaPorNome(nome);
        System.out.println("Agencia encontrada:");
        System.out.println(agencia);
    }
}
