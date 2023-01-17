package br.com.ada.grupo3.locadora.view;

import java.util.Scanner;

public class CapturadorDeEntrada {

    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String nomeCampo) {
        System.out.print("Informar o %s: ".formatted(nomeCampo));
        String entrada = scanner.nextLine();
        return entrada;
    }

    public static Integer capturarInteger(String nomeCampo) {
        System.out.print("Informar o número %s: ".formatted(nomeCampo));

        boolean repetir = true;
        int retorno = 0;

        while (repetir) {
            String valor = scanner.nextLine();
            try {
                retorno = Integer.parseInt(valor);
                if (retorno < 0) {
                    throw new NumberFormatException();
                }
                repetir = false;
            } catch (NumberFormatException | NullPointerException ex) {
                System.out.println("\u001B[31mO valor entrado não é válido!\u001B[0m");
                System.out.print("Entre com um número inteiro positivo: ");
            }
        }
        return retorno;
    }
}

