package br.com.ada.grupo3.locadora;

import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.persistence.AgenciaRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AgenciaUtilDatabase {

    public static void saveAgenciasBkp(AgenciaRepository agenciaRepository) {
        String bkpText = AgenciaBkpText(agenciaRepository.listarTodos());
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

    public static String AgenciaBkpText(List<Agencia> elements) {
        StringBuilder sb = new StringBuilder();

        for (Agencia element : elements) {
            sb.append("agencia");
            sb.append(",");
            sb.append(element.getNome());
            sb.append(",");
            sb.append(element.getEndereco().getString());
            sb.append(",");
            sb.append(element.getTelefone());
            sb.append(",");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void loadAgenciasFromFile(AgenciaRepository agenciaRepository) {

        try {
            File bkpFile = new File(("bkp_agencias.csv"));

            if (!bkpFile.exists()) {
                System.out.println("Não há cadastros de agências persistidos");
                return;
            }

            Scanner sc = new Scanner(bkpFile);

            while (sc.hasNextLine()) {
                String[] rowData = sc.nextLine().split(",");

                if (rowData[0].equalsIgnoreCase("agencia")) {
                    String nome = rowData[1].trim();
                    String[] enderecoStr = rowData[2].split("\\$");
                    String telefone = rowData[3].trim();
                    Endereco enderecoLido = new Endereco(enderecoStr[0], Integer.parseInt(enderecoStr[1]), enderecoStr[2], enderecoStr[3]);
                    Agencia agenciaLida = new Agencia(nome, enderecoLido, telefone);
                    agenciaRepository.salvar(agenciaLida);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}