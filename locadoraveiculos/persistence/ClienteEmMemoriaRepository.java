package br.com.ada.projeto.locadoraveiculos.persistence;
import br.com.ada.projeto.locadoraveiculos.model.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteEmMemoriaRepository extends RepositorioGenericoAbstract<Cliente> implements ClienteRepository<Cliente> {

    @Override
    public Cliente cadastrarCliente(boolean cadastroCompleto) {
        TipoCliente tipoCliente = ClienteController.cadastrarTipoCliente();
        List<String> nomeDoc = ClienteController.cadastrarNomeEDocumento();
        Cliente cliente = new Cliente(nomeDoc.get(0), nomeDoc.get(1), tipoCliente);
        if (cadastroCompleto) ClienteController.cadastrarInfosExtras(cliente);
        return cliente;
    }
    @Override
    public List<Cliente> buscarPeloNome(String parteNome) {
        List<Cliente> clientesComParteDesseNome = new ArrayList<>();
        for (Cliente cliente : entidades.values()) {
            if (cliente.getNome().contains(parteNome)) {
                clientesComParteDesseNome.add(cliente);
            }
        }
        return clientesComParteDesseNome;
    }
    @Override
    public void alterarCliente(String id) {
        Cliente cliente = this.entidades.get(id);
        ClienteController.alterarInfos(cliente);
        this.entidades.remove(id);
        this.entidades.put(cliente.getDocumento(), cliente);
    }
    @Override
    public void remover(Cliente entidade) {
        if (!this.entidades.isEmpty()) {
            this.entidades.remove(entidade.getId(), entidade);
        }
    }

}

