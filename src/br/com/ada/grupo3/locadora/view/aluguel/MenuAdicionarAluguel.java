package br.com.ada.grupo3.locadora.view.aluguel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepository;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepositoryInMemory;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;

public class MenuAdicionarAluguel extends MenuAbstrato {

    private final AluguelManager gerenciadorDeAluguel;
    private final VeiculoManager gerenciadorDeVeiculo;

    public MenuAdicionarAluguel(AluguelManager gerenciadorDeAluguel, VeiculoManager gerenciadorDeVeiculo) {
        super("Adicionar aluguel");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
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


        String cliente = CapturadorDeEntrada.capturarString("Id do cliente");
        String veiculo = CapturadorDeEntrada.capturarString("Id do veiculo");
        String agenciaRetirada = CapturadorDeEntrada.capturarString("Id da agencia de retirada");
        String agenciaDevolucao = CapturadorDeEntrada.capturarString("Id da agencia de devoluçao");


        LocalDateTime dataRetirada = LocalDateTime.now();

        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Quantos dias planejados?");

        Veiculo v = gerenciadorDeVeiculo.buscarVeiculoPorID(veiculo);
        System.out.println(v);
        //Aluguel aluguel = gerenciadorDeAluguel.criarAluguel(cliente, veiculo, agenciaRetirada, agenciaDevolucao, dataRetirada, diasAlugados);

        System.out.println("Aluguel adicionado com sucesso");
        System.out.println("Nova Aluguel:");
    }
}
