package org.example.cliente.model.exception;

public class ClienteNotFoundException extends RuntimeException {
    private String errMessage;

    public ClienteNotFoundException(String errMessage) {
        super(errMessage);
    }

    public ClienteNotFoundException(){
        super();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
