package br.com.ada.grupo3.locadora.persistence;

import java.util.List;

public interface GenericRepository<T> {

    void salvar(T entidade);

    void remover(T entidade);

    List<T> listarTodos();

    T buscarPeloId(String identificador);
}
