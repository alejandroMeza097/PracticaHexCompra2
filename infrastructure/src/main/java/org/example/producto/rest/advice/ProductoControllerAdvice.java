package org.example.producto.rest.advice;

import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProductoControllerAdvice {

    public ResponseEntity<String> handleEmptyInput(ProductoNotFoundException productoNotFoundException){
        return new ResponseEntity<>(productoNotFoundException.getErrMessage(), HttpStatus.BAD_REQUEST);
    }
}
