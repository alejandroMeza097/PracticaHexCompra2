package org.example.producto.model.exception;

public class ProductoException extends  RuntimeException {
    private String errMessage;

    public ProductoException(String errMessage) {
        this.errMessage = errMessage;
    }

    public ProductoException(){

    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
