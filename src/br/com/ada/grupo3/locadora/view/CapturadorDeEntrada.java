package br.com.ada.grupo3.locadora.view;

import br.com.ada.grupo3.locadora.exception.DadoInvalidoException;
import br.com.ada.grupo3.locadora.model.TipoVeiculo;

import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.InputMismatchException;
public class CapturadorDeEntrada {

    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String nomeCampo) {
        System.out.print("Informar o %s: ".formatted(nomeCampo));
        return scanner.nextLine();
    }

    public static String capturarStringNaoVazia(String nomeCampo) {
        System.out.print("Informar %s: ".formatted(nomeCampo));

        boolean repetir = true;
        String retorno = "";

        while (repetir) {
            String valor = scanner.nextLine();
            try {
                retorno = valor.trim();
                if (retorno.equals("")) {
                    throw new DadoInvalidoException();
                }
                repetir = false;
            } catch (DadoInvalidoException ex) {
                System.out.println(ex.getMessage());
                System.out.print("Informar %s, diferente de vazio: ".formatted(nomeCampo));
            }
        }
        return retorno;
    }

    public static Integer capturarInteger(String nomeCampo) {
        System.out.print("Informar %s: ".formatted(nomeCampo));

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
                System.out.println("\u001B[31mO dado entrado não é válido!\u001B[0m");
                System.out.print("Entre com um número inteiro positivo: ");
            }
        }
        return retorno;
    }

    public static BigDecimal capturarBigDecimal(String nomeCampo) {
        System.out.print("Informar %s: ".formatted(nomeCampo));

        boolean repetir = true;
        BigDecimal retorno = BigDecimal.ZERO;

        while (repetir) {
            String valor = scanner.nextLine();
            try {
                retorno = BigDecimal.valueOf(Double.parseDouble(valor));
                if (retorno.signum() == -1) {
                    throw new NumberFormatException();
                }
                repetir = false;
            } catch (InputMismatchException | NumberFormatException | NullPointerException ex) {
                System.out.println("\u001B[31mO valor entrado não é válido!\u001B[0m");
                System.out.print("Entre com um valor positivo: ");
            }
        }
        return retorno;
    }

    public static TipoVeiculo capturaSelecao(List<TipoVeiculo> tiposDeVeiculos) {
        for (int i = 0; i < tiposDeVeiculos.size(); i++) {
            System.out.println(i + ". " + tiposDeVeiculos.get(i).getDescricao());
        }
        int selecao = capturarInteger("Selecione um tipo de veículo: ");

        while (selecao >= tiposDeVeiculos.size()) {
            System.out.println("Seleção inválida!");
            selecao = capturarInteger("Selecione um tipo de veículo: ");
        }
        return tiposDeVeiculos.get(selecao);
    }

    // LITERALMENTE O CONSOLE UI HELPER COLADO A PARTIR DAQUI
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String askSimpleInput(String message) {
        String texto = null;
        boolean continuar = true;
        while (continuar) {
            System.out.printf("%s%n# : ", message);
            texto = new Scanner(System.in).nextLine().trim();
            if (texto.length()< 1) {
                System.out.println("Digite um texto valido.");
            }else continuar = false;
        }
        return texto;
    }

    public static String askNoEmptyInput(String message, int retries) {
        System.out.printf("%s%n# : ", message);
        Scanner sc = new Scanner(System.in);
        String input;
        int tries = 0;
        do {
            input = sc.nextLine().trim();
            tries++;
        } while (input.isBlank() && retries > 0 && tries < retries);
        return input;
    }

    public static int askChooseOption(String message, String... options) {
        System.out.printf("%s%n# : ", message);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d - %s%n# : ", i + 1, options[i]);

        }
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            try {
                choose = Integer.parseInt(sc.next());
            } catch (InputMismatchException | NumberFormatException e) {
                choose = -9;
            }
            if (choose < 1 || choose > options.length) System.out.println("Digite um valor valido.");
        } while (choose < 1 || choose > options.length);
        return choose;
    }

    public static boolean askConfirm(String message, String yes, String no) {
        String[] op = new String[2];
        op[0] = yes;
        op[1] = no;
        return askChooseOption(message, yes, no) == 1;
    }

    public static BigDecimal askNumber(String message) {
        System.out.printf("%s%n# : ", message);
        Scanner sc = new Scanner(System.in);
        BigDecimal number;
        do {
            try {
                number = sc.nextBigDecimal();
            } catch (InputMismatchException e) {
                number = null;
            }
        } while (number == null);
        return number;
    }

    public static Integer askInt(String message) {
        System.out.printf("%s%n# : ", message);
        Scanner sc = new Scanner(System.in);
        Integer number;
        do {
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                number = null;
            }
        } while (number == null);
        return number;
    }

    public static int drawWithRightPadding(String text, int width, char pad) {
        int count = 0;
        do {
            int limit = Math.min(text.length(), width - 4);
            String row = text.substring(0, limit);
            text = text.substring(row.length());
            row = "# " + row + String.valueOf(pad).repeat(width - row.length() - 4) + " #";
            System.out.println(row);
            count++;
        } while (!text.isEmpty());
        return count;
    }

    public static int drawWithPadding(String text, int width) {
        int count = 0;
        do {
            int limit = Math.min(text.length(), width - 4);
            String row = text.substring(0, limit);
            text = text.substring(row.length());
            int padding = (width - row.length()) / 2;
            row = "#" + " ".repeat(padding - 1) + row;
            row = row + " ".repeat(width - row.length() - 1) + "#";
            System.out.println(row);
            count++;
        } while (!text.isEmpty());
        return count;
    }

    public static void drawHeader(String title, int width) {
        drawLine(width);
        drawWithPadding(title, width);
        drawLine(width);
    }

    public static void drawLine(int width) {
        System.out.println("#".repeat(width));
    }

    public static void fillVSpace(int lines, int width) {
        drawWithPadding(" ".repeat(lines * width), width);
    }

    public static String columnPaddingLeft(String text, int width, char pad) {
        while (text.length() < width) {
            text = String.valueOf(pad).concat(text);
        }
        return text;
    }

    public static String columnPaddingRight(String text, int width, char pad) {
        while (text.length() < width) {
            text = text.concat(String.valueOf(pad));
        }
        return text;
    }
}



