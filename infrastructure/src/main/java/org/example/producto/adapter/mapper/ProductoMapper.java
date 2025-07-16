package org.example.producto.adapter.mapper;


import org.example.cliente.adapter.entity.ClienteEntity;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.adapter.entity.ProductoEntity;
import org.example.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    //metodo para convertir de JPA a dominio (Producto)
    public Producto toDomain(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Producto(
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getStock()
        );
    }

    // Convierte de dominio(Producto) a entidad JPA - Entity
    public ProductoEntity toEntity(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(producto.getNombre());
        entity.setPrecio(producto.getPrecio());
        entity.setStock(producto.getStock());
        return entity;
    }
}
