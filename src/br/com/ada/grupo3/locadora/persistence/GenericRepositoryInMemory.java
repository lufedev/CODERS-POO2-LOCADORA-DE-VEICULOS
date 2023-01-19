package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.Entidade;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRepositoryInMemory<T extends Entidade> implements GenericRepository<T> {

    protected Map<String, T> entidades;

    public GenericRepositoryInMemory() {
        this.entidades = new HashMap<>();
    }

    @Override
    public void salvar(T entidade) {
        this.entidades.put(entidade.getId(), entidade);
    }

    @Override
    public void remover(T entidade) {
        this.entidades.remove(entidade.getId());
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public T buscarPeloId(String identificador) {
        return entidades.get(identificador);
    }
}
