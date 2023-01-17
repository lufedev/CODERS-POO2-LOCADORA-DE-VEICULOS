package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuAdicionarAgencia extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;
    public MenuAdicionarAgencia(AgenciaManager gerenciadorDeAgencia) {
        super("Adicionar agencia");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da nova agencia");

        while (gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Já existe uma agencia com o nome " + nome);
            nome = CapturadorDeEntrada.capturarString("nome da nova agencia");
        }
        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova agencia");
        int numero = CapturadorDeEntrada.capturarInteger("número da nova agencia");
        String cidade = CapturadorDeEntrada.capturarString("cidade da nova agencia");
        String uf = CapturadorDeEntrada.capturarString("UF da nova agencia");
        Agencia agencia = gerenciadorDeAgencia.criarAgencia(nome, new Endereco(logradouro, numero, cidade, uf));

        System.out.println("Agencia adicionada com sucesso");
        System.out.println("Nova Agencia:");
        System.out.println(agencia);
    }
}
