package br.com.ada.grupo3.locadora.domain;
import br.com.ada.grupo3.locadora.model.Aluguel;
import br.com.ada.grupo3.locadora.model.Cliente;
import br.com.ada.grupo3.locadora.model.Veiculo;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.AluguelUtilDatabase;
import br.com.ada.grupo3.locadora.exception.RegistroDuplicadoException;
import br.com.ada.grupo3.locadora.persistence.AluguelRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class AluguelManager {

    private final AluguelRepository aluguelRepository;

    public AluguelManager(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Aluguel criarAluguel(Cliente cliente,Cliente motorista, Veiculo veiculo, Agencia agenciaRetirada, Agencia agenciaDevolucao, LocalDateTime dataRetirada, Integer diasAlugados) {


        Aluguel novaAluguel = new Aluguel(cliente,motorista, veiculo, agenciaRetirada, agenciaDevolucao, dataRetirada, diasAlugados);
        aluguelRepository.salvar(novaAluguel);
        AluguelUtilDatabase.saveAluguelBkp(aluguelRepository);
        return novaAluguel;
    }
//    public Aluguel calcularPreco(){
//        return aluguelRepository.calcularPreco();
//    }

    public Aluguel buscarAluguelPorNome(String nome) {
        return aluguelRepository.buscarPeloId(nome);
    }

    public List<Aluguel> buscarAluguelPorNomeParcial (String parteUUID) {
        return aluguelRepository.buscarPeloNomeParcial(parteUUID);
    }
    public  List<String> listarTodosAlugueis () {
        return aluguelRepository.listarTodosAlugueis();
    }
    public  List<String> listarTodosAlugueisAbertos () {
        return aluguelRepository.listarTodosAlugueisAbertos();
    }
    public boolean existeAluguel(String UUID) {
        return aluguelRepository.buscarPeloId(UUID) != null;
    }
}
