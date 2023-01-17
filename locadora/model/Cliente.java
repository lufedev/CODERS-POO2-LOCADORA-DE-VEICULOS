package br.com.ada.grupo3.locadora.model;

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
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
