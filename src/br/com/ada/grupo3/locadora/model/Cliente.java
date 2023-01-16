package br.com.ada.grupo3.locadora.model;

public class Cliente implements Entidade {

    private String nome;
    private String documento;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private final TipoCliente tipoCliente;

    public Cliente(String nome, String documento, TipoCliente tipoCliente) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, String documento, TipoCliente tipoCliente, String email, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
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

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + '\'' + ", documento='" + documento + '\'' + '}';
    }
}
