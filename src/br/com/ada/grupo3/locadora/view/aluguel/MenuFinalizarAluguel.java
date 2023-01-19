package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuFinalizarAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    public MenuFinalizarAluguel(AluguelManager gerenciadorDeAluguel) {
        super("Finalizar aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        String UUID = CapturadorDeEntrada.capturarString("UUID do aluguel: ");
        Aluguel a = gerenciadorDeAluguel.buscarAluguelPorNome(UUID);
        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Quantos dias planejados? ");

        a.diaFinal(diasAlugados);
        a.calcularPreco();
        a.encerrarAluguel();


    }
}
