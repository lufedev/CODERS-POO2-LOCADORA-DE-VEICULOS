package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuAlterarAgenciaAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    private final AgenciaManager gerenciadorDeAgencia;

    public MenuAlterarAgenciaAluguel(AluguelManager gerenciadorDeAluguel, AgenciaManager gerenciadorDeAgencia) {
        super("Aterar agência aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }


    @Override
    public void acao(){
        String UUID = CapturadorDeEntrada.capturarString("UUID do aluguel: ");
        if (!gerenciadorDeAluguel.existeAluguel(UUID)) {
            System.out.println("Não existe aluguel com o nome " + UUID);
            return;
        }
        Aluguel aluguel = gerenciadorDeAluguel.buscarAluguelPorNome(UUID);
        System.out.println("Agências do contrato: " + aluguel.getId());
        System.out.println(aluguel.getAgencias());

        System.out.println();
        Integer agenciaEscolhida = CapturadorDeEntrada.capturarInteger("\n1 - Alterar agência aluguel \n 2 - Alterar agência devolução \n");
        String idAgencia = CapturadorDeEntrada.capturarString("Id da agencia");
        Agencia agencia = gerenciadorDeAgencia.buscarAgenciaPorId(idAgencia);
        if (agencia == null){
            System.out.println("Agência inválida - cancelando operação");
            return;
        }
        if (agenciaEscolhida == 1){
            aluguel.setAgenciaRetirada(agencia);
        }
        else if (agenciaEscolhida == 2){
            aluguel.setAgenciaDevolucao(agencia);
        }
        else {
            System.out.println("Valor inválido -  cancelando operação");
            return;
        }
        System.out.println("Agência alterada!");
        System.out.println(aluguel);
    }
}