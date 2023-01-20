package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.PaginacaoListas;

import java.util.List;

public class MenuBuscarAluguelPorNome extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;

    public MenuBuscarAluguelPorNome(AluguelManager gerenciadorDeAluguel) {
        super("Buscar aluguel por nome");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        String UUID = CapturadorDeEntrada.capturarString("UUID do aluguel");
        List<Aluguel> aluguelComUUIDBuscada = gerenciadorDeAluguel.buscarAluguelPorNomeParcial(UUID);

        if (aluguelComUUIDBuscada.isEmpty()) {
            System.out.println("Não existe aluguel com o nome " + UUID);
            return;
        }
        listarAluguel(aluguelComUUIDBuscada);
    }


    public void listarAluguel(List<Aluguel> aluguelComUUIDBuscada) {
        PaginacaoListas.listarEmPaginas(aluguelComUUIDBuscada, "");

    }
}
