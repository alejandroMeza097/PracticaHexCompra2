package org.example.compra.adapter.entiy;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="detalle_venta")
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productoId;
    private String nombre;
    private int cantidad;
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaEntity venta;
}
