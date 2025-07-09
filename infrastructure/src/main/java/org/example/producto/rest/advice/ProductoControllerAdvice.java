package org.example.producto.rest.advice;
import org.example.producto.adapter.ProductoErrorResponse;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.exception.ProductoException;
import org.example.producto.model.exception.ProductoIlegalException;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ProductoControllerAdvice {

    @ExceptionHandler(ProductoIlegalException.class)
    public ResponseEntity<ProductoErrorResponse> handleProductoIlegalException(ProductoIlegalException ex) {
        ProductoErrorResponse response = new ProductoErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Producto no válido",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<ProductoErrorResponse>handleProductoException(ProductoException ex){
        ProductoErrorResponse response = new ProductoErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Producto agregado anteriormente",
                ex.getMessage()
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
