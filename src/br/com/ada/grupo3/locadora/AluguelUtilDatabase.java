package br.com.ada.grupo3.locadora;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.domain.AluguelManager;
import br.com.ada.grupo3.locadora.domain.ClienteManager;
import br.com.ada.grupo3.locadora.domain.VeiculoManager;
import br.com.ada.grupo3.locadora.model.*;
import br.com.ada.grupo3.locadora.persistence.AgenciaRepository;
import br.com.ada.grupo3.locadora.persistence.AluguelRepository;
import br.com.ada.grupo3.locadora.persistence.ClienteRepository;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepository;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AluguelUtilDatabase {

    public static void saveAluguelBkp(AluguelRepository aluguelRepository) {
        String bkpText = AluguelBkpText(aluguelRepository.listarTodos());
        saveFile(bkpText, "bkp_agencias");
    }

    public static void saveFile(String bkpText, String nomeArquivo) {
        try {
            File bkpFile = new File((nomeArquivo + ".csv"));

            FileWriter out = new FileWriter(bkpFile);
            out.append(bkpText);
            out.close();
            System.out.println("Conteudo gravado em arquivo");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String AluguelBkpText(List<Aluguel> elements) {
        StringBuilder sb = new StringBuilder();

        for (Aluguel element : elements) {
            sb.append("aluguel");
            sb.append(",");
            sb.append(element.getCliente());
            sb.append(",");
            sb.append(element.getMotorista());
            sb.append(",");
            sb.append(element.getVeiculoId());
            sb.append(",");
            sb.append(element.getAgenciaRetiradaId());
            sb.append(",");
            sb.append(element.getAgenciaDevolucaoId());
            sb.append(",");
            sb.append(element.getDataDevolucaoPrevista().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            sb.append(",");
            sb.append(element.getDiasAlugados());
            sb.append(",");
            sb.append(element.getStatus());
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void loadAluguelFromFile(AluguelRepository aluguelRepository,VeiculoManager gerenciadorDeVeiculo, AgenciaManager gerenciadorDeAgencia, ClienteManager gerenciadorDeCliente) {


        try {
            File bkpFile = new File(("bkp_aluguel.csv"));

            if (!bkpFile.exists()) {
                System.out.println("Não há cadastros de alugueis persistidos");
                return;
            }

            Scanner sc = new Scanner(bkpFile);

            while (sc.hasNextLine()) {
                String[] rowData = sc.nextLine().split(",");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                if (rowData[0].equalsIgnoreCase("aluguel")) {
                    String cliente = rowData[1].trim();
                    Cliente c = gerenciadorDeCliente.buscarPeloId(cliente);
                    if (c == null){
                        System.out.println("Cliente nao encontrado - CANCELANDO OPERAÇÃO");
                        return;
                    }
                    String motorista = rowData[2].trim();
                    Cliente m = gerenciadorDeCliente.buscarPeloId(motorista);
                    if (m == null){
                        System.out.println("Motorista nao encontrado - CANCELANDO OPERAÇÃO");
                        return;
                    }
                    String veiculo = rowData[3].trim();
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
                    String agenciaRetirada = rowData[4].trim();
                    Agencia a = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaRetirada);
                    if (a == null){
                        System.out.println("Agência inválida - CANCELANDO OPERAÇÃO");
                        return;
                    }
                    String agenciaDevolucao = rowData[5].trim();

                    Agencia a2 = gerenciadorDeAgencia.buscarAgenciaPorId(agenciaRetirada);
                    if (a2 == null){
                        System.out.println("Agência inválida - CANCELANDO OPERAÇÃO");
                        return;
                    }

                    LocalDateTime dataRetirada = LocalDateTime.parse(rowData[6].trim(),dtf);
                    Integer diasAlugados = Integer.valueOf(rowData[7].trim());

//                    Cliente cliente = rowData[1].trim();
//                    Cliente cliente = rowData[1].trim();
//                    String[] enderecoStr = rowData[2].split("\\$");
//                    String telefone = rowData[3].trim();
//                    Endereco enderecoLido = new Endereco(enderecoStr[0], Integer.parseInt(enderecoStr[1]), enderecoStr[2], enderecoStr[3]);
//                    Agencia agenciaLida = new Agencia(nome, enderecoLido, telefone);
//                    agenciaRepository.salvar(agenciaLida);
                    Aluguel aluguel = new Aluguel(c,m, v, a, a2, dataRetirada, diasAlugados);
                    aluguelRepository.salvar(aluguel);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}