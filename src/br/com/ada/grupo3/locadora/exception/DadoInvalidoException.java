package br.com.ada.grupo3.locadora.exception;

public class DadoInvalidoException extends RuntimeException {

    public DadoInvalidoException() {
        super("\u001B[31mO dado entrado não é válido!\u001B[0m");
    }
}
