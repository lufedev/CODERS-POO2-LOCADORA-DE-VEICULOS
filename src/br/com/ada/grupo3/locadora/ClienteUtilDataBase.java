package br.com.ada.grupo3.locadora;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.TipoCliente;
import br.com.ada.grupo3.locadora.persistence.ClienteRepository;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ClienteUtilDataBase {

    public static void saveClientesBkp(ClienteRepository clienteRepository) {
        String bkpText = ClientesBkpText(clienteRepository.listarTodos());
        saveFile(bkpText, "bkp_clientes");
    }

    public static void saveFile(String bkpText, String nomeArquivo) {
        try {
            File bkpFile = new File((nomeArquivo + ".csv"));

            FileWriter out = new FileWriter(bkpFile);
            if (!bkpFile.exists()) {
                System.out.println("");
                out.append("Nome/Documento/TipoCliente/Email/Endereço/Telefone\n");
            }
            out.append(bkpText);
            out.close();
            System.out.println("Conteudo gravado em arquivo");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String ClientesBkpText(List<Cliente> elements) {
        StringBuilder sb = new StringBuilder();

        for (Cliente element : elements) {
            sb.append("cliente");
            sb.append(",");
            sb.append(element.getNome());
            sb.append(",");
            sb.append(element.getDocumento());
            sb.append(",");
            sb.append(element.getTipoCliente().getString());
            sb.append(",");
            sb.append(element.getEmail());
            sb.append(",");
            sb.append(element.getEndereco());
            sb.append(",");
            sb.append(element.getTelefone());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void loadClientesFromFile(ClienteRepository clienteRepository) {
        try {
            File bkpFile = new File(("bkp_clientes.csv"));

            if (!bkpFile.exists()) {
                System.out.println("Nao ha cadastro de clientes persistidos");
                return;
            }
            Scanner sc = new Scanner(bkpFile);
            while (sc.hasNextLine()) {
                String[] rowData = sc.nextLine().split(",");

                if (rowData[0].equalsIgnoreCase("cliente")) {
                    String nome = rowData[1].trim();
                    String documento = rowData[2].trim();
                    String[] tipoClienteStr = rowData[3].split("\\$");
                    TipoCliente tipoCliente = new TipoCliente(tipoClienteStr[0], BigDecimal.valueOf(Long.parseLong(tipoClienteStr[1])), Integer.parseInt(tipoClienteStr[2]));
                    String email = rowData[4].trim();
                    String endereco = rowData[5].trim();
                    String telefone = rowData[6].trim();
                    Cliente clienteLida = new Cliente(nome, documento, tipoCliente, email, endereco, telefone);
                    System.out.println(clienteLida);
                    clienteRepository.salvar(clienteLida);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}