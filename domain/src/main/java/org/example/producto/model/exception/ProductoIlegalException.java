package org.example.producto.model.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoIlegalException extends  RuntimeException {
    private String errMessage;

    public ProductoIlegalException(String errMessage) {
        super(errMessage);
    }



}
