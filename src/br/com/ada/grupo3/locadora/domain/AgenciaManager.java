package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.exception.RegistroDuplicadoException;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.persistence.AgenciaRepository;


public class AgenciaManager {

    private final AgenciaRepository agenciaRepository;

    public AgenciaManager(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public Agencia criarAgencia(String nome, Endereco endereco) {
        if (existeAgencia(nome)) {
            throw new RegistroDuplicadoException("Agencia", nome);
        }

        Agencia novaAgencia = new Agencia(nome, endereco);
        agenciaRepository.salvar(novaAgencia);
        return novaAgencia;
    }

    public Agencia buscarAgenciaPorNome(String nome) {
        return agenciaRepository.buscarPeloId(nome);
    }

    public boolean existeAgencia(String nome) {
        return agenciaRepository.buscarPeloId(nome) != null;
    }
}
