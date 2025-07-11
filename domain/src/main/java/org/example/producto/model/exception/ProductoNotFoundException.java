package org.example.producto.model.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoNotFoundException extends RuntimeException{

    public ProductoNotFoundException(String errMessage) {
        super(errMessage);
    }


}
