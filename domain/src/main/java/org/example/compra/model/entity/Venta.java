package org.example.compra.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Venta {
    private Long id;
    private Long clienteId;
    private List<DetalleVenta> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

}
