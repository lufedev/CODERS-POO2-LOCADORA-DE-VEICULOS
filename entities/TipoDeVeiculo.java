package entities;

import java.math.BigInteger;

public enum TipoDeVeiculo {
    MOTO(new BigInteger("100.00")),
    CARRO(new BigInteger("150.00")),
    CAMINHAO(new BigInteger("200.00"));

    final private BigInteger valorDiaria;

    TipoDeVeiculo(BigInteger valorDiaria) {
    this.valorDiaria = valorDiaria;
    }
    public BigInteger getValorDiaria(){
        return valorDiaria;
    }
}
