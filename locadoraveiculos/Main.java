package br.com.ada.projeto.locadoraveiculos;

import br.com.ada.projeto.locadoraveiculos.model.Agencia;
import br.com.ada.projeto.locadoraveiculos.model.Cliente;
import br.com.ada.projeto.locadoraveiculos.model.TipoCliente;
import br.com.ada.projeto.locadoraveiculos.persistence.AgenciaEmMemoriaRepository;
import br.com.ada.projeto.locadoraveiculos.persistence.ClienteEmMemoriaRepository;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClienteEmMemoriaRepository clientRepository = new ClienteEmMemoriaRepository();
        TipoCliente pf = new TipoCliente("Pessoa Fisica", new BigDecimal(5), 3);
        Cliente c1 = new Cliente("Vinicius", "63513431007", pf);
        Cliente c2 = new Cliente("Rodrigo", "48073096099", pf);
        Cliente c3 = new Cliente("Ana", "3247899865", pf);
        Cliente c4 = new Cliente("Jao", "3656475867", pf);
        Cliente c5 = new Cliente("Ze", "987655467", pf);

        clientRepository.salvar(c1);
        clientRepository.salvar(c2);

        List<Cliente> vinis = clientRepository.buscarPeloNome("Vini");
        Cliente ney = clientRepository.buscarPeloId("48073096099");

        System.out.println(clientRepository.getEntidades());
        System.out.println(vinis);
        System.out.println(ney.getNome());

        AgenciaEmMemoriaRepository agenciaRepository = new AgenciaEmMemoriaRepository();
        agenciaRepository.salvar(new Agencia("AG1", "Sao Paulo"));
        Agencia ag1 = agenciaRepository.buscarPeloId("AG1");
        System.out.println(ag1);
    }
}
