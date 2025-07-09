package org.example.producto.adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
public class ProductoErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

    public ProductoErrorResponse(HttpStatus status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = error;
        this.message = message;
    }
}
