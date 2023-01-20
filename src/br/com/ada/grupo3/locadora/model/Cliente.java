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
        return this.documento;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String getId() {
        return this.getDocumento();
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
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
    public String getTipo(){
        return tipoCliente.toString();
    }
    //devolve apenas "pessoa fisica"||"pessoa juridica"
    public String getTipoRaw(){
        return tipoCliente.rawString();
    }

    public String getTipoDescricao() {return tipoCliente.getDescricao();}

    public String toString() {
        return String.format("""
                        Cliente
                        Nome: %s
                        documento: %s
                        E-mail: %s
                        Endereço: %s
                        Telefone: %s
                        Tipo de Cliente: %s
                        """, nome, documento, email, endereco, telefone, getTipoDescricao());
    }

}