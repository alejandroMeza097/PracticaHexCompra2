package org.example.compra.adapter.mapper;

import org.example.compra.adapter.entiy.DetalleVentaEntity;
import org.example.compra.adapter.entiy.VentaEntity;
import org.example.compra.model.entity.DetalleVenta;
import org.example.compra.model.entity.Venta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VentaMapper {

    public VentaEntity toEntity(Venta venta){
        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setClienteId(venta.getClienteId());
        ventaEntity.setPrecioTotal(venta.getPrecioTotal());

        List<DetalleVentaEntity> detalles = venta.getProductos().stream().map(p ->{
            DetalleVentaEntity detalleVentaEntity = new DetalleVentaEntity();
            detalleVentaEntity.setProductoId(p.getProductoId());
            detalleVentaEntity.setNombre(p.getNombre());
            detalleVentaEntity.setCantidad(p.getCantidad());
            detalleVentaEntity.setPrecioUnitario(p.getPrecioUnitario());
            detalleVentaEntity.setVenta(ventaEntity);
            return detalleVentaEntity;
        }).toList();
        ventaEntity.setProductos(detalles);
        return ventaEntity;

    }

    public Venta toDomain(VentaEntity ventaEntity){
        Venta venta = new Venta();
        venta.setClienteId(ventaEntity.getClienteId());
        venta.setPrecioTotal(ventaEntity.getPrecioTotal());
        venta.setFechaCompra(ventaEntity.getFechaCompra());

        List<DetalleVenta> detalles = ventaEntity.getProductos().stream().map(p->{
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProductoId(p.getProductoId());
            detalleVenta.setNombre(p.getNombre());
            detalleVenta.setCantidad(p.getCantidad());
            detalleVenta.setPrecioUnitario(p.getPrecioUnitario());
            return detalleVenta;
        }).toList();

        venta.setProductos(detalles);
        return venta;
    }
}
