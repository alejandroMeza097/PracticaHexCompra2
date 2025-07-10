package org.example.producto.model.exception;

public class ProductoException extends  RuntimeException {
    private String errMessage;

    public ProductoException(String errMessage) {
        super(errMessage);
    }

    public ProductoException(){
        super();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
