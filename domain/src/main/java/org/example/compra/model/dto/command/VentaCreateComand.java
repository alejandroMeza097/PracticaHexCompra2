package org.example.compra.model.dto.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.compra.model.dto.ProductoCantidadDto;
import org.example.compra.model.entity.DetalleVenta;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaCreateComand {
    private Long clienteId;
    private List<ProductoCantidadDto> productos;

}
