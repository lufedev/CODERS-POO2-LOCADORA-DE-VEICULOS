package br.com.ada.grupo3.locadora.model;

import java.util.Objects;

public class Cliente implements Entidade {

    private String nome;

    private String documento;

    private String email;

    private Endereco endenreco;

    private Telefone telefone;

    private TipoCliente tipoCliente;

    public Cliente() {
    }

    public Cliente(String nome, String documento, TipoCliente tipoCliente) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, String documento, TipoCliente tipoCliente, String email, Endereco endenreco, Telefone telefone) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.email = email;
        this.endenreco = endenreco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getId() {
        return documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndenreco(Endereco endenreco) {
        this.endenreco = endenreco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getNome(), cliente.getNome()) && Objects.equals(documento, cliente.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), documento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
