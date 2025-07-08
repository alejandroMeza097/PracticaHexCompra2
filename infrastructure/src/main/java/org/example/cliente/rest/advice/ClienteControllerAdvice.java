package org.example.cliente.rest.advice;


import org.example.cliente.model.exception.ClienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ClienteControllerAdvice {
    public ResponseEntity<String> handleEmptyInput(ClienteException clienteException){
        return new ResponseEntity<>(clienteException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
}
