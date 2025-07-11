package org.example.compra.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.exception.ClienteNotFoundException;
import org.example.compra.model.dto.ProductoCantidadDto;
import org.example.compra.model.dto.command.VentaCreateComand;
import org.example.compra.model.entity.DetalleVenta;
import org.example.compra.model.entity.Venta;
import org.example.compra.port.dao.ClienteValidacionDao;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.compra.port.repository.VentaRepository;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoIlegalException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class VentaCreateService {
    private final ClienteValidacionDao clienteValidacionDao;
    private final ProductoValidacionDao productoValidacionDao;
    private  final VentaRepository ventaRepository;
    private final ProductoDatosDao productoDatosDao;

    public Venta execute(VentaCreateComand ventaCreateComand){

        List<DetalleVenta> detalleVentaList = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;


        if(!clienteValidacionDao.existeCliente(ventaCreateComand.getClienteId())){
            throw new ClienteNotFoundException("Cliente NO encontrado");
        }



        for(ProductoCantidadDto productoCantidadDto : ventaCreateComand.getProductos()){
            if(productoCantidadDto == null){
                throw new ProductoIlegalException("Prodcuto ingresado con errores");
            }
            if(productoCantidadDto.getCantidad() < 0){
                throw new ProductoIlegalException("La cantidad debe ser mayor a cero");
            }

            if(!productoValidacionDao.existeProducto(productoCantidadDto.getProductoId())){
                throw new ProductoIlegalException("El id del producto NO es valido:" + productoCantidadDto.getProductoId());
            }

            Producto producto = productoDatosDao.obtenerDatos(productoCantidadDto.getProductoId());
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProductoId(producto.getId());
            detalleVenta.setNombre(producto.getNombre());
            detalleVenta.setCantidad(productoCantidadDto.getCantidad());
            detalleVenta.setPrecioUnitario(producto.getPrecio());
            detalleVentaList.add(detalleVenta);

            total = total.add(detalleVenta.getPrecioUnitario().multiply(BigDecimal.valueOf(detalleVenta.getCantidad())));
        }

        Venta venta = new Venta();
        venta.setClienteId(ventaCreateComand.getClienteId());
        venta.setProductos(detalleVentaList);
        venta.setPrecioTotal(total);
        venta.setFechaCompra(LocalDateTime.now());

        return ventaRepository.guardarVenta(venta);

    }

}
