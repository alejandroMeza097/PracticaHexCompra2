package org.example.producto.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoCreateCommand {
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}
