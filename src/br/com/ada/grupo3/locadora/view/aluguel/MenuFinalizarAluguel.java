package br.com.ada.grupo3.locadora.view.aluguel;

import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuFinalizarAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    public MenuFinalizarAluguel(AluguelManager gerenciadorDeAluguel) {
        super("Finalizar aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
//        String nome = CapturadorDeEntrada.capturarString("nome da nova aluguel");
//
//        while (gerenciadorDeAluguel.existeAluguel(nome)) {
//            System.out.println("Já existe uma aluguel com o nome " + nome);
//            nome = CapturadorDeEntrada.capturarString("nome da nova aluguel");
//        }
//        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova aluguel");
//        int numero = CapturadorDeEntrada.capturarInteger("número da nova aluguel");
//        String cidade = CapturadorDeEntrada.capturarString("cidade da nova aluguel");
//        String uf = CapturadorDeEntrada.capturarString("UF da nova aluguel");
//        Aluguel aluguel = gerenciadorDeAluguel.criarAluguel(nome, new Endereco(logradouro, numero, cidade, uf));
//
//        System.out.println("Aluguel adicionada com sucesso");
//        System.out.println("Nova Aluguel:");
//        System.out.println(aluguel);
    }
}
