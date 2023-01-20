package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuFinalizarAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuFinalizarAluguel(AluguelManager gerenciadorDeAluguel, VeiculoManager gerenciadorDeVeiculo) {
        super("Finalizar aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {

        String UUID = CapturadorDeEntrada.capturarString("UUID do aluguel: ");
        if (!gerenciadorDeAluguel.existeAluguel(UUID)) {
            System.out.println("Não existe aluguel com o nome " + UUID);
            return;
        }
        Aluguel a = gerenciadorDeAluguel.buscarAluguelPorNome(UUID);
        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Veículo alugado por quantos dias? ");

        a.diaFinal(diasAlugados);
        a.encerrarAluguel();

        Veiculo v = gerenciadorDeVeiculo.buscarVeiculoPorID(a.getVeiculoId());
        v.devolverCarro();
        System.out.println(a);

    }
}
