package br.com.fiap.locatech.service.exceptions;

public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException (String message) {
        super(message);
    }
}
