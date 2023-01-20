package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.List;

public class MenuListarAgencias extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuListarAgencias(AgenciaManager gerenciadorDeAgencia) {
        super("Listar todas agências");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {

        List<Agencia> agencias = gerenciadorDeAgencia.buscarTodasAgencias();

        if (agencias.isEmpty()) {
            System.out.println("A lista de agências está vazia");
            return;
        }

        listarAgencias(agencias);
    }

    public void listarAgencias(List<Agencia> agencias) {

//        agencias.forEach(System.out::println);
        PaginacaoListas.listarEmPaginas(agencias, "Lista de agências");
    }
}
