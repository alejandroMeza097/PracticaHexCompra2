package org.example.compra.port.repository;

import org.example.compra.model.dto.command.VentaCreateComand;
import org.example.compra.model.entity.Venta;

public interface VentaRepository {
    Venta guardarVenta(Venta venta);
}
