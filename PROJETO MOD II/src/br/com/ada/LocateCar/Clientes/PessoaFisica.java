package br.com.ada.LocateCar.Clientes;

import java.util.Objects;

public class PessoaFisica extends Cliente {
    private String cpf;
    private String cnh;
    private String nome;

//    public PessoaFisica(long id, Endereco endereco, String email, Telefone telefone) {
//        super(id, endereco, email, telefone);
//    }

    public PessoaFisica(long id, Endereco endereco, String email, Telefone telefone, String cpf, String cnh, String nome) {
        super(id, endereco, email, telefone);
        this.cpf = cpf;
        this.cnh = cnh;
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected String getCnh() {
        return cnh;
    }

    protected void setCnh(String cnh) {
        this.cnh = cnh;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaFisica that)) return false;
        if (!super.equals(o)) return false;
        return cpf.equals(that.cpf) && cnh.equals(that.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, cnh);
    }
}
//Pessoa - Ian
//        String CPF
//        String CNH
//        String CEP
//        Endereço
//        String Telefone
//        String E-mail
