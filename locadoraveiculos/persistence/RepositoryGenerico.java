package br.com.ada.projeto.locadoraveiculos.persistence;

import br.com.ada.projeto.locadoraveiculos.model.Agencia;

public interface RepositoryGenerico<T> {

    void salvar(T entidade);

    void remover(T entidade);

    T buscarPeloId(String identificador);
}
