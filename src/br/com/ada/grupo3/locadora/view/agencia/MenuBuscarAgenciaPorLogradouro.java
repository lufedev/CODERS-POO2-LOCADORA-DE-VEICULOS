package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.List;

public class MenuBuscarAgenciaPorLogradouro extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuBuscarAgenciaPorLogradouro(AgenciaManager gerenciadorDeAgencia) {
        super("Buscar agencia por parte do logradouro");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String parteDoLogradouro = CapturadorDeEntrada.capturarString("parte do logradouro da agencia buscada");

        List<Agencia> agencias = gerenciadorDeAgencia.buscarAgenciaPeloLogradouro(parteDoLogradouro);

        if (agencias.isEmpty()) {
            System.out.printf("Não existe agencia com a palavra %s no logradouro.%n", parteDoLogradouro);
            return;
        }
        PaginacaoListas.listarEmPaginas(agencias, "Lista de agências encontradas");
    }
}
