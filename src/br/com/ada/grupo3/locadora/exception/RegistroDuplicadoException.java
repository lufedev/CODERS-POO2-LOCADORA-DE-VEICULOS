package br.com.ada.grupo3.locadora.exception;

public class RegistroDuplicadoException extends RuntimeException {

    public RegistroDuplicadoException(String tipoDoRegistro, String valorDoId) {
        super("Já existe um(a) %s com identificador %s".formatted(tipoDoRegistro, valorDoId));
    }
}
