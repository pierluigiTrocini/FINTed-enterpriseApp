package it.unical.demacs.pierluigi.fintedapp.exception;

public class CredentialsAlreadyUsedException extends Exception {
    public CredentialsAlreadyUsedException(String message){
        super(message);
    }
}
