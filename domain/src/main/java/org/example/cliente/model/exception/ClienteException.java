package org.example.cliente.model.exception;

public class ClienteException extends RuntimeException {
    private String errorMessage;

    public ClienteException(){

    }

    public ClienteException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



}
