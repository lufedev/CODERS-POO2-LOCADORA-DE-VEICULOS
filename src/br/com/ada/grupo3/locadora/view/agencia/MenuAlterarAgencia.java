package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuAlterarAgencia extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;

    public MenuAlterarAgencia(AgenciaManager gerenciadorDeAgencia) {
        super("Alterar agência");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {

        String nome = CapturadorDeEntrada.capturarString("nome da agência a ser alterado");

        while (!gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Não existe uma agência com o nome " + nome);
            nome = CapturadorDeEntrada.capturarString("nome da agência a ser alterada ou <0> para cancelar operação");
            if (nome.equals("0")) return;
        }
        Agencia agencia = gerenciadorDeAgencia.buscarAgenciaPorNome(nome);

        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova agência");
        int numero = CapturadorDeEntrada.capturarInteger("número da nova agência");
        String cidade = CapturadorDeEntrada.capturarString("cidade da nova agência");
        String uf = CapturadorDeEntrada.capturarString("UF da nova agência");

        gerenciadorDeAgencia.removerAgencia(agencia);
        agencia = gerenciadorDeAgencia.criarAgencia(nome, new Endereco(logradouro, numero, cidade, uf));

        System.out.println("Agência editada com sucesso");
        System.out.println("Agência:");
        System.out.println(agencia);
    }
}
