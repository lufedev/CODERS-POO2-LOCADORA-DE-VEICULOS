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
        Cliente c = gerenciadorDeCliente.buscarPeloId(cliente);
        if (c == null){
            System.out.println("Cliente nao encontrado - CANCELANDO OPERAÇÃO");
            return;
        }
        String motorista = CapturadorDeEntrada.capturarString("Documento do Motorista: ");
        Cliente m = gerenciadorDeCliente.buscarPeloId(motorista);
        if (m == null){
            System.out.println("Motorista nao encontrado - CANCELANDO OPERAÇÃO");
            return;
        }
        String veiculo = CapturadorDeEntrada.capturarString("Placa do veiculo: ");
        Veiculo v = gerenciadorDeVeiculo.buscarVeiculoPorID(veiculo);
        if (v == null){
            System.out.println("Veiculo nao encontrado - CANCELANDO OPERAÇÃO");
            return;
        }
        if (v.getDisponivel()){
            v.alugarCarro();
        }
        else{
            System.out.println("Veículo já se encontra alugado! ");
            return;
        }
        String agenciaRetirada = CapturadorDeEntrada.capturarString("Id da agencia de retirada: ");
        Agencia a = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaRetirada);
        if (a == null){
            System.out.println("Agência inválida - CANCELANDO OPERAÇÃO");
            return;
        }
        String agenciaDevolucao = CapturadorDeEntrada.capturarString("Id da agencia de devoluçao: ");

        Agencia a2 = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaRetirada);
        if (a2 == null){
            System.out.println("Agência inválida - CANCELANDO OPERAÇÃO");
            return;
        }

        LocalDateTime dataRetirada = LocalDateTime.now();
        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Quantos dias planejados? ");

        Aluguel aluguel = gerenciadorDeAluguel.criarAluguel(c,m, v, a, a2, dataRetirada, diasAlugados);

        System.out.println("Aluguel adicionado com sucesso");

        //Resultados serão printados sem inicializar o objeto, apenas para visualizar como seria a saída disso

        System.out.println(aluguel);
        //ADICIONAR DESCONTO NO CALCULO E MOVER ISSO PARA A CLASSE ALUGUEL

    }
}
