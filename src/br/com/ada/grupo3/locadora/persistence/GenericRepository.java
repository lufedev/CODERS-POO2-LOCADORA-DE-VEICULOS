package br.com.ada.grupo3.locadora.persistence;

public interface GenericRepository<T> {

    void salvar(T entidade);

    void remover(T entidade);

    T buscarPeloId(String identificador);
}
