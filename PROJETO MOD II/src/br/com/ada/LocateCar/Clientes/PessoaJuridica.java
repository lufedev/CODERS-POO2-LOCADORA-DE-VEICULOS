package br.com.ada.LocateCar.Clientes;

import java.util.Objects;

public class PessoaJuridica extends Cliente{
   private String cnpj;
   private String razaoSocial;
   private String nomeFantasia;

    public PessoaJuridica(long id, Endereco endereco, String email, Telefone telefone, String cnpj, String razaoSocial, String nomeFantasia) {
        super(id, endereco, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public PessoaJuridica(long id, String cnpj, String razaoSocial, String nomeFantasia) {
        super(id);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    protected String getCnpj() {
        return cnpj;
    }

    protected void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    protected String getRazaoSocial() {
        return razaoSocial;
    }

    protected void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    protected String getNomeFantasia() {
        return nomeFantasia;
    }

    protected void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaJuridica that)) return false;
        if (!super.equals(o)) return false;
        return cnpj.equals(that.cnpj) && razaoSocial.equals(that.razaoSocial) && nomeFantasia.equals(that.nomeFantasia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cnpj, razaoSocial, nomeFantasia);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "ID='" + id + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}'  + "\n";
    }
}
//Empresa - Ian
//        String CNPJ
//        String razãoSocial
//        String nomeFantasia
//        Endereço
//        String Telefone
//        String E-mail

