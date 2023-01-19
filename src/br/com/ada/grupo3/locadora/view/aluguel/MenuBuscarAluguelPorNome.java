package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuBuscarAluguelPorNome extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;

    public MenuBuscarAluguelPorNome(AluguelManager gerenciadorDeAluguel) {
        super("Buscar aluguel por nome");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
//        String nome = CapturadorDeEntrada.capturarString("nome da aluguel buscada");
//
//        if (!gerenciadorDeAluguel.existeAluguel(nome)) {
//            System.out.println("Não existe aluguel com o nome " + nome);
//            return;
//        }
//
//        Aluguel aluguel = gerenciadorDeAluguel.buscarAluguelPorNome(nome);
//        System.out.println("Aluguel encontrada:");
//        System.out.println(aluguel);
    }
}
