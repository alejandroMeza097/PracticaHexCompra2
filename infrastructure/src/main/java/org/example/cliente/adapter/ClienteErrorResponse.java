package org.example.cliente.adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
public class ClienteErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

    public ClienteErrorResponse(HttpStatus status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = error;
        this.message = message;
    }
}
