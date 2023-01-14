package br.com.ada.projeto.locadoraveiculos;
import br.com.ada.projeto.locadoraveiculos.view.ClientesMenu;

import java.util.Scanner;

public class Main2Clientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientesMenu menuCliente = new ClientesMenu();
        menuCliente.menuClientes(sc);

    }
}
