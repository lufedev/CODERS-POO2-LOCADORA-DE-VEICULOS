package br.com.ada.grupo3.locadora.view.aluguel;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import br.com.ada.grupo3.locadora.domain.AluguelManager;

import java.util.List;

public class MenuListarAlugueis extends MenuAbstrato{

    private final AluguelManager gerenciadorDeAluguel;
    public MenuListarAlugueis(AluguelManager gerenciadorDeAluguel) {
        super("Listar todos os alugueis");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }
    @Override
    public void acao(){
        List<String> aluguelList = gerenciadorDeAluguel.listarTodosAlugueis();
        listarAluguel(aluguelList);
    }
    public void listarAluguel(List<String> aluguelList) {
        PaginacaoListas.listarEmPaginas(aluguelList, "");

    }
}
