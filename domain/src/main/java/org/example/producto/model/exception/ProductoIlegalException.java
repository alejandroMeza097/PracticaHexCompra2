package org.example.producto.model.exception;

public class ProductoIlegalException extends  RuntimeException {
    private String errMessage;

    public ProductoIlegalException(String errMessage) {
        this.errMessage = errMessage;
    }

    public ProductoIlegalException() {

    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
