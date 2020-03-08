package br.com.caelum.clines.exceptions;

public class AlreadyExistsException extends IllegalArgumentException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
