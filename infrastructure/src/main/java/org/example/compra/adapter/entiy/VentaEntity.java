package org.example.compra.adapter.entiy;


import jakarta.persistence.*;
import org.example.compra.model.entity.DetalleVenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetalleVenta> productos;
}
