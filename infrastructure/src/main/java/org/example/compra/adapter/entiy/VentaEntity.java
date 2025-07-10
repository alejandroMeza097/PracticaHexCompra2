package org.example.compra.adapter.entiy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.compra.model.entity.DetalleVenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
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
    private List<DetalleVentaEntity> productos;
}
