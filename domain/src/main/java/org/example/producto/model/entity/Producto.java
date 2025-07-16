package org.example.producto.model.entity;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.producto.model.dto.command.ProductoCreateCommand;

import java.math.BigDecimal;

@Setter
@NoArgsConstructor
public class Producto {
    private ProductoId id;
    private ProductoNombre nombre;
    private ProductoPrecio precio;
    private ProductoStock stock;


    public Producto(Long id, String nombre, BigDecimal precio,Integer stock ) {
        this.id = new ProductoId(id);
        this.nombre = new ProductoNombre(nombre);
        this.precio = new ProductoPrecio(precio);
        this.stock = new ProductoStock(stock);

    }
    public Producto requestToCreate(ProductoCreateCommand productoCreateCommand){
        this.nombre = new ProductoNombre(productoCreateCommand.getNombre());
        this.precio = new ProductoPrecio(productoCreateCommand.getPrecio());
        this.stock = new ProductoStock(productoCreateCommand.getStock());
        return this;
    }

    public Long getId() {
        return id.getId();
    }

    public String getNombre() {
        return nombre.getNombre();
    }

    public BigDecimal getPrecio() {
        return precio.getPrecio();
    }

    public Integer getStock(){return stock.getStock();}

}
