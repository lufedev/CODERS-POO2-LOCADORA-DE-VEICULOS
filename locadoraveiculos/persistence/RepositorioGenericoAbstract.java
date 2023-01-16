package br.com.ada.projeto.locadoraveiculos.persistence;

import br.com.ada.projeto.locadoraveiculos.model.Cliente;
import br.com.ada.projeto.locadoraveiculos.model.Entidade;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RepositorioGenericoAbstract<T extends Entidade> implements RepositoryGenerico<T> {

    protected Map<String, T> entidades;

    public RepositorioGenericoAbstract() {
        this.entidades = new HashMap<>();
    }

    @Override
    public void salvar(T entidade) {this.entidades.put(entidade.getId(), entidade);}

    @Override
    public void remover(T entidade) {this.entidades.remove(entidade);}

    @Override
    public T buscarPeloId(String identificador) {
        return entidades.get(identificador);
    }

    public Map<String, T> getEntidades() {
        return Collections.unmodifiableMap(entidades);
    }
}
