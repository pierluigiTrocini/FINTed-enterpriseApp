package it.unical.demacs.pierluigi.fintedapp.exception;

@Deprecated
public class ImagesLimitExceededException extends Exception {
    public ImagesLimitExceededException(String message){
        super(message);
    }
}
