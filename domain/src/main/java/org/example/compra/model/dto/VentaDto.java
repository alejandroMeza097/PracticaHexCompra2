package org.example.compra.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.compra.model.entity.DetalleVenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaDto {
    private Long id;
    private Long clienteId;
    private List<DetalleVenta> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

}
