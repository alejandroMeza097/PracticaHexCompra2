package org.example.producto.model.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoException extends  RuntimeException {
    private String errMessage;

    public ProductoException(String errMessage) {
        super(errMessage);
    }

    public ProductoException(){
        super();
    }

}
