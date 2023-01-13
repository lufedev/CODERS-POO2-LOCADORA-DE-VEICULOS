package br.com.ada.LocateCar;

import br.com.ada.LocateCar.Clientes.Cliente;
import br.com.ada.LocateCar.Clientes.ClientesRepositorio;
import br.com.ada.LocateCar.Clientes.PessoaFisica;
import br.com.ada.LocateCar.Clientes.PessoaJuridica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientesRepositorio cr = new ClientesRepositorio();
        PessoaFisica pf1 = new PessoaFisica(3246709, "43256", "8756", "ana");
        PessoaFisica pf2 = new PessoaFisica(8745354, "9654325", "23965", "joao");
        PessoaFisica pf3 = new PessoaFisica(1423576, "1234", "00000", "maria");
        PessoaFisica pf4 = new PessoaFisica(3246709, "1987", "0976", "ana maria");
        PessoaJuridica pj1 = new PessoaJuridica(9087563, "07896543567/986", "coca cola company", "Coca-cola");
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(pf1, pf2, pf3, pf4, pj1));
        cr.setClientes(clientes);
        boolean flag = false;
        do {
            System.out.println("Menu 1 2 3 4");
            String menu = sc.next();
            cr.listarClientes();
            switch (menu) {
                case "1" -> cr.cadastrarCliente();
                case "2" -> cr.buscarCliente();
                case "3" -> cr.alterarCliente();
                case "4" -> cr.removerCliente();
                case "5" -> flag = true;
            }
        } while (!flag);

    }
}