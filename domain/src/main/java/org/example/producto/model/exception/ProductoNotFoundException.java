package org.example.producto.model.exception;

public class ProductoNotFoundException extends RuntimeException{
    private String errMessage;

    public ProductoNotFoundException(String errMessage) {
        this.errMessage = errMessage;
    }

    public ProductoNotFoundException() {

    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
