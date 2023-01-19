package br.com.ada.grupo3.locadora.view.aluguel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.model.*;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepository;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepositoryInMemory;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;

public class MenuAdicionarAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    private final VeiculoManager gerenciadorDeVeiculo;
    private final AgenciaManager gerenciadorDeAgencia;
    private final ClienteManager gerenciadorDeCliente;

    public MenuAdicionarAluguel(AluguelManager gerenciadorDeAluguel, ClienteManager gerenciadorDeCliente, AgenciaManager gerenciadorDeAgencia, VeiculoManager gerenciadorDeVeiculo) {
        super("Adicionar aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
        this.gerenciadorDeCliente = gerenciadorDeCliente;
    }
/*
    Contrato - Luiz
   Boolean emAberto
   Cliente
   AgenciaRetirada
   Veiculo
   AgenciaDevolução
   DataRetirada
   DataPrevista(aparece ao retirar omite ao devolver)
   DataFinal (aparece ao devolver omite ao retirar)
   CondutorCadastrado
   ValorPrevisto(aparece ao retirar omite ao devolver)
   ValorFinal (aparece ao devolver omite ao retirar)
 */
    @Override
    public void acao() {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        String nome = CapturadorDeEntrada.capturarString("nome da nova aluguel");
//
//        while (gerenciadorDeAluguel.existeAluguel(nome)) {
//            System.out.println("Já existe uma aluguel com o nome " + nome);
//            nome = CapturadorDeEntrada.capturarString("nome da nova aluguel");
//        }


        String cliente = CapturadorDeEntrada.capturarString("Documento do cliente: ");
        String motorista = CapturadorDeEntrada.capturarString("Documento do Motorista: ");
        String veiculo = CapturadorDeEntrada.capturarString("Placa do veiculo: ");
        String agenciaRetirada = CapturadorDeEntrada.capturarString("Id da agencia de retirada: ");
        String agenciaDevolucao = CapturadorDeEntrada.capturarString("Id da agencia de devoluçao: ");
        LocalDateTime dataRetirada = LocalDateTime.now();
        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Quantos dias planejados? ");

        //Cliente C  e Motorista M
        Cliente c = gerenciadorDeCliente.buscarPeloId(cliente);
        Cliente m = gerenciadorDeCliente.buscarPeloId(motorista);
        //Veiculo V
        Veiculo v = gerenciadorDeVeiculo.buscarVeiculoPorID(veiculo);
        //AgenciaRetirada A e AgenciaDevolucao A2
        Agencia a = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaRetirada);
        Agencia a2 = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaDevolucao);

        Aluguel aluguel = gerenciadorDeAluguel.criarAluguel(c,m, v, a, a2, dataRetirada, diasAlugados);

        System.out.println("Aluguel adicionado com sucesso");
        System.out.println(c.getTipoRaw());

        //Resultados serão printados sem inicializar o objeto, apenas para visualizar como seria a saída disso
        System.out.println("=========CONTRATO:" + aluguel.getId() + "==============");
        System.out.println("Cliente: " + aluguel.getCliente());
        System.out.println("Veiculo: "+aluguel.getVeiculo());
        System.out.println(aluguel.getAgencias());
        System.out.println(aluguel.getDatas());
        System.out.println(aluguel.calcularPreco());
//        System.out.println("Data Prevista da devolução " + dataRetirada.plus(diasAlugados, ChronoUnit.DAYS));

        //ADICIONAR DESCONTO NO CALCULO E MOVER ISSO PARA A CLASSE ALUGUEL

    }
}
