package org.example.compra.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleVenta {
    private Long productoId;
    private String nombre;
    private int cantidad;
    private BigDecimal precioUnitario;
}
