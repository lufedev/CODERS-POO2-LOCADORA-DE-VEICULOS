package br.com.ada.grupo3.locadora.persistence;

import br.com.ada.grupo3.locadora.model.*;
import br.com.ada.grupo3.locadora.view.ClienteController;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmMemoriaRepository extends RepositorioGenericoAbstract<Cliente> implements ClienteRepository<Cliente> {
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


    // Novas implementacoes a validar se local seria aqui mesmo

    // Será que essa funcionalidade não seria melhor implementar como sendo uma chamada
    // de criacaode reqistro (ex a da ClienteController) e posterior chamada salvar
    // (já implementado na RepoGenAbstr)?
//    @Override
//    public Cliente cadastrarCliente(boolean cadastroCompleto) {
//        TipoCliente tipoCliente = ClienteController.cadastrarTipoCliente();
//        List<String> nomeDoc = ClienteController.cadastrarNomeEDocumento();
//        Cliente cliente = new Cliente(nomeDoc.get(0), nomeDoc.get(1), tipoCliente);
//        if (cadastroCompleto) cliente = ClienteController.cadastrarInfosExtras(cliente);
//        return cliente;
//    }


    // Será que essa funcionalidade não seria melhor implementar como sendo uma chamada
    // para buscarPeloId (que já esta implementado no RepoGenAbstr) mais
    // uma chamada de edicao (a da ClienteController) e posterior chamada salvar
    // (tb já implementado na RepoGenAbstr)? Como é map, se já existir ele altera o
    // existente...
//    @Override
//    public void alterarCliente(String id) {
//        Cliente cliente = this.entidades.get(id);
//        ClienteController.alterarInfos(cliente);
//        this.entidades.remove(id);
//        this.entidades.put(cliente.getDocumento(), cliente);
//    }

    //Ja implementado no RepositorioGenericoAbstrato - o teste de vazio
    // não é necessário pois o método remove é uma operacao opcional
    // (também nao sabia, vi na descricao da funcao ;) ...
//    @Override
//    public void remover(Cliente entidade) {
//        if (!this.entidades.isEmpty()) {
//            this.entidades.remove(entidade.getId(), entidade);
//        }
//    }

}

