package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.List;

public class MenuBuscarAgenciaPorNome extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuBuscarAgenciaPorNome(AgenciaManager gerenciadorDeAgencia) {
        super("Buscar agencia por parte do nome");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da agencia buscada");
        List<Agencia> agencias = gerenciadorDeAgencia.buscarAgenciaPeloNome(nome);

        if (agencias.isEmpty()) {
            System.out.println("Não existe agencia com o nome " + nome);
            return;
        }
        PaginacaoListas.listarEmPaginas(agencias, "Lista de agências encontradas");

    }
}
