package org.example.cliente.rest.advice;


import org.example.cliente.adapter.ClienteErrorResponse;
import org.example.cliente.model.exception.ClienteException;
import org.example.cliente.model.exception.ClienteIlegalInputException;
import org.example.cliente.model.exception.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteControllerAdvice {

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<ClienteErrorResponse> handleClienteException(ClienteException ex){
        ClienteErrorResponse response = new ClienteErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Cliente invalido",
                ex.getMessage()
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClienteIlegalInputException.class)
    public ResponseEntity<ClienteErrorResponse> handleClienteIlegalInputException(ClienteIlegalInputException ex){
        ClienteErrorResponse response = new ClienteErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Datos incorrectos",
                ex.getMessage()
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ClienteErrorResponse>handleClienteNotFoundException(ClienteNotFoundException ex){
        ClienteErrorResponse response = new ClienteErrorResponse(
                HttpStatus.NOT_FOUND,
                "Cliente NO encontrado",
                ex.getMessage()
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


}
