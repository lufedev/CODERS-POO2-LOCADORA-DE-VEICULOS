package br.com.ada.grupo3.locadora.domain;

import br.com.ada.grupo3.locadora.exception.RegistroDuplicadoException;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.persistence.AgenciaRepository;

import java.util.List;

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

    public void removerAgencia(Agencia agencia) {
        agenciaRepository.remover(agencia);
    }

    public List<Agencia> buscarTodasAgencias() {
        return agenciaRepository.listarTodos();
    }

    public List<Agencia> buscarAgenciaPeloNome(String nome) {
        return agenciaRepository.buscarPeloNomeParcial(nome);
    }

    public List<Agencia> buscarAgenciaPeloLogradouro(String logradouro) {
        return agenciaRepository.buscarPeloLogradouroParcial(logradouro);
    }

    public Agencia buscarAgenciaPorId(String nome) {
        return agenciaRepository.buscarPeloId(nome);
    }

    public boolean existeAgencia(String nome) {
        return agenciaRepository.buscarPeloId(nome) != null;
    }
}