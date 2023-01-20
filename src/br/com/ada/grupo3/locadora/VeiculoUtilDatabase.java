package br.com.ada.grupo3.locadora;

import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.persistence.VeiculoRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class VeiculoUtilDatabase {

    public static void saveVeiculosBkp(VeiculoRepository veiculoRepository) {
        String bkpText = VeiculoBkpText(veiculoRepository.listarTodos());
        saveFile(bkpText, "bkp_veiculos");
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

    public static String VeiculoBkpText(List<Veiculo> elements) {
        StringBuilder sb = new StringBuilder();

        for (Veiculo element : elements) {
            sb.append("veiculo");
            sb.append(",");
            sb.append(element.getPlaca());
            sb.append(",");
            sb.append(element.getModelo());
            sb.append(",");
            sb.append(element.getFabricante());
            sb.append(",");
            sb.append(element.getStrDisponivel());
            sb.append(",");
            sb.append(element.getTipo().getString());
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void loadVeiculosFromFile(VeiculoRepository veiculoRepository) {

        try {

            File bkpFile = new File(("bkp_veiculos.csv"));

            if (!bkpFile.exists()) {
                System.out.println("Não há cadastros de veículos persistidos");
                return;
            }

            Scanner sc = new Scanner(bkpFile);

            while (sc.hasNextLine()) {
                String[] rowData = sc.nextLine().split(",");

                if (rowData[0].equalsIgnoreCase("veiculo")) {
                    String placa = rowData[1].trim();
                    String modelo = rowData[2].trim();
                    String fabricante = rowData[3].trim();
                    Boolean disponivel = Boolean.valueOf(rowData[4].trim());
                    String[] tipoVeiculoStr = rowData[5].split("\\$");

                    TipoVeiculo tipoVeiculoLido = new TipoVeiculo(tipoVeiculoStr[0], new BigDecimal(tipoVeiculoStr[1]));

                    Veiculo veiculoLido = new Veiculo(placa, modelo, fabricante, tipoVeiculoLido);
                    veiculoLido.setDisponivel(disponivel);

                    veiculoRepository.salvar(veiculoLido);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}