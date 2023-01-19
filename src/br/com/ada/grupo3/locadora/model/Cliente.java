package br.com.ada.grupo3.locadora.model;

public class Cliente implements Entidade {

    private String nome;
    private final String documento;
    private String email;
    private String endereco;
    private String telefone;
    private final TipoCliente tipoCliente;


    public Cliente(String nome,String documento, TipoCliente tipoCliente, String email, String endereco, String telefone) {
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
        return this.getDocumento();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
