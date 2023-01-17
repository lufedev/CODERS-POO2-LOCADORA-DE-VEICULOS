package br.com.ada.grupo3.locadora;

//import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.TipoCliente;
//import br.com.ada.grupo3.locadora.persistence.AgenciaEmMemoriaRepository;
import br.com.ada.grupo3.locadora.persistence.ClienteEmMemoriaRepository;
import br.com.ada.grupo3.locadora.view.cliente.MenuClienteFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ClienteEmMemoriaRepository clientRepository = new ClienteEmMemoriaRepository();
//        TipoCliente pf = new TipoCliente("Pessoa Fisica", new BigDecimal(5), 3);
//        Cliente c1 = new Cliente("Vinicius", "63513431007", pf);
//        Cliente c2 = new Cliente("Rodrigo", "48073096099", pf);
//        Cliente c3 = new Cliente("Ana", "3247899865", pf);
//        Cliente c4 = new Cliente("Jao", "3656475867", pf);
//        Cliente c5 = new Cliente("Ze", "987655467", pf);
//
//        clientRepository.salvar(c1);
//        clientRepository.salvar(c2);
//
//        List<Cliente> vinis = clientRepository.buscarPeloNome("Vini");
//        Cliente ney = clientRepository.buscarPeloId("48073096099");
//
//        System.out.println(clientRepository.getEntidades());
//        System.out.println(vinis);
//        System.out.println(ney.getNome());
//
//        AgenciaEmMemoriaRepository agenciaRepository = new AgenciaEmMemoriaRepository();
//        agenciaRepository.salvar(new Agencia("AG1", "Sao Paulo"));
//        Agencia ag1 = agenciaRepository.buscarPeloId("AG1");
//        System.out.println(ag1);

        Scanner sc = new Scanner(System.in);
        MenuClienteFactory menu = new MenuClienteFactory();
        TipoCliente tc = new TipoCliente("Pessoa Fisica", BigDecimal.valueOf(5), 5);
        Cliente cl1 = new Cliente("Ian", "12345", tc);
        Cliente cl2 = new Cliente("Ana", "54321", tc);
        Cliente cl3 = new Cliente("Joao", "98765", tc);
        Cliente cl4 = new Cliente("Maria", "56789", tc);
        ClienteEmMemoriaRepository cr = new ClienteEmMemoriaRepository();
        cr.salvar(cl1);
        cr.salvar(cl2);
        cr.salvar(cl3);
        cr.salvar(cl4);
        boolean continuar;
        do {
            menu.create().exibir();
            menu.create().agir();
            System.out.println("deseja continuar?");
            int resp = sc.nextInt();
            continuar = (resp==1) ? true : false;
        }while(continuar);


    }
}
