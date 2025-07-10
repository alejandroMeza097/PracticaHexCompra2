package org.example.cliente.model.exception;

public class ClienteIlegalInputException  extends RuntimeException{

    private String errMessage;

    public ClienteIlegalInputException(String errMessage) {
        super(errMessage);
    }
    public ClienteIlegalInputException(){
        super();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
