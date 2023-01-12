package br.com.ada.LocateCar.Clientes;
import java.util.Objects;

public abstract class Cliente {
    public long id;
    private Endereco endereco;
    private String email;
    private Telefone telefone;

    public Cliente(long id, Endereco endereco, String email, Telefone telefone) {
        this.id = id;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    protected long getId() {
        return id;
    }

    protected Endereco getEndereco() {
        return endereco;
    }

    protected void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected Telefone getTelefone() {
        return telefone;
    }

    protected void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
