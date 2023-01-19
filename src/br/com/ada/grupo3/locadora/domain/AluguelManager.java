package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.persistence.AluguelRepository;


public class AluguelManager {

    private final AluguelRepository aluguelRepository;

    public AluguelManager(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

//    public Aluguel criarAluguel(String nome, String endereco) {
//        if (existeAluguel(nome)) {
//            throw new RegistroDuplicadoException("Aluguel", nome);
//        }
//
//        Aluguel novaAluguel = new Aluguel(nome, endereco);
//        AluguelRepository.salvar(novaAluguel);
//        return novaAluguel;
//    }
//
//    public Aluguel buscarAluguelPorNome(String nome) {
//        return AluguelRepository.buscarPeloId(nome);
//    }
//
//    public boolean existeAluguel(String nome) {
//        return AluguelRepository.buscarPeloId(nome) != null;
//    }
}
