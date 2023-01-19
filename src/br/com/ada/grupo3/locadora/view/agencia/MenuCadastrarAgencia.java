package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuCadastrarAgencia extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;
    public MenuCadastrarAgencia(AgenciaManager gerenciadorDeAgencia) {
        super("Adicionar agência");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da nova agência");

        while (gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Já existe uma agência com o nome " + nome);
            nome = CapturadorDeEntrada.capturarString("nome da nova agência");
        }
        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova agência");
        int numero = CapturadorDeEntrada.capturarInteger("número da nova agência");
        String cidade = CapturadorDeEntrada.capturarString("cidade da nova agência");
        String uf = CapturadorDeEntrada.capturarString("UF da nova agência");
        Agencia agencia = gerenciadorDeAgencia.criarAgencia(nome, new Endereco(logradouro, numero, cidade, uf));

        System.out.println("Agência adicionada com sucesso");
        System.out.println("Nova agência:");
        System.out.println(agencia);
    }
}
