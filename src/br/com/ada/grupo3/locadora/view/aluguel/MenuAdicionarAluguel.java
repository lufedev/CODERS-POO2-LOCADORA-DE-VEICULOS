package br.com.ada.grupo3.locadora.view.aluguel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.ada.grupo3.locadora.model.TipoVeiculo;
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

        Integer valor = 0;
        String cliente = CapturadorDeEntrada.capturarString("Id do cliente");
        String veiculo = CapturadorDeEntrada.capturarString("Id do veiculo");
        String agenciaRetirada = CapturadorDeEntrada.capturarString("Id da agencia de retirada");
        String agenciaDevolucao = CapturadorDeEntrada.capturarString("Id da agencia de devoluçao");


        LocalDateTime dataRetirada = LocalDateTime.now();

        Integer diasAlugados = CapturadorDeEntrada.capturarInteger("Quantos dias planejados?");

        Veiculo v = gerenciadorDeVeiculo.buscarVeiculoPorID(veiculo);


        //Coletar o preço do veículo
        TipoVeiculo tV = v.getTipo();

        //Aluguel aluguel = gerenciadorDeAluguel.criarAluguel(cliente, veiculo, agenciaRetirada, agenciaDevolucao, dataRetirada, diasAlugados);

        System.out.println("Aluguel adicionado com sucesso");
        System.out.println("Nova Aluguel:");

        //Resultados serão printados sem inicializar o objeto, apenas para visualizar como seria a saída disso
        System.out.println("=========CONTRATO==============");
        System.out.println("Cliente: " + cliente);
        System.out.println("Veiculo: Modelo: " + v.getModelo() +" placa: " + v.getId());
        System.out.println("Agencia Retirada: " + agenciaRetirada);
        System.out.println("Agencia Devolucao: " + agenciaDevolucao);
        System.out.println("Data Retirada " + dataRetirada);
        System.out.println("Data Prevista da devolução " + dataRetirada.plus(diasAlugados, ChronoUnit.DAYS));

        //ADICIONAR DESCONTO NO CALCULO E MOVER ISSO PARA A CLASSE ALUGUEL
        switch(tV.getDescricao()){
            case ("Carro"):
                valor = 150 * diasAlugados;
                System.out.println("Valor total R$" + valor);
                break;
            case ("Moto"):
                valor = 100 * diasAlugados;
                System.out.println("Valor total R$" + valor);
                break;
            case ("Caminhão"):
                valor = 200 * diasAlugados;
                System.out.println("Valor total R$" + valor);
                break;
        }

    }
}
