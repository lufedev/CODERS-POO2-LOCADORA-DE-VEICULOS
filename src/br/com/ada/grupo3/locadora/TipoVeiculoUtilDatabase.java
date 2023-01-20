package br.com.ada.grupo3.locadora;

import br.com.ada.grupo3.locadora.model.TipoVeiculo;
import br.com.ada.grupo3.locadora.persistence.TipoVeiculoRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TipoVeiculoUtilDatabase {

    public static void saveTipoVeiculosBkp(TipoVeiculoRepository tipoVeiculoRepository) {
        String bkpText = TipoVeiculoBkpText(tipoVeiculoRepository.listarTodos());
        saveFile(bkpText, "bkp_tipoveiculos");
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

    public static String TipoVeiculoBkpText(List<TipoVeiculo> elements) {
        StringBuilder sb = new StringBuilder();

        for (TipoVeiculo element : elements) {
            sb.append("tipo_veiculo");
            sb.append(",");
            sb.append(element.getDescricao());
            sb.append(",");
            sb.append(element.getTarifa());
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void loadTipoVeiculoFromFile(TipoVeiculoRepository tipoVeiculoRepository) {

        try {

            File bkpFile = new File(("bkp_tipoveiculos.csv"));

            if (!bkpFile.exists()) {
                System.out.println("Não há cadastros de tipos de veículos persistidos");
                return;
            }

            Scanner sc = new Scanner(bkpFile);

            while (sc.hasNextLine()) {
                String[] rowData = sc.nextLine().split(",");

                if (rowData[0].equalsIgnoreCase("tipo_veiculo")) {
                    String descricao = rowData[1].trim();
                    BigDecimal tarifa = new BigDecimal(rowData[2].trim());

                    TipoVeiculo tipoVeiculoLido = new TipoVeiculo(descricao, tarifa);

                    tipoVeiculoRepository.salvar(tipoVeiculoLido);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}