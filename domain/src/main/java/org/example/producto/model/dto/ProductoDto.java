package org.example.producto.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}
