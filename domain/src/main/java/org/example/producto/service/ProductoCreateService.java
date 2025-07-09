package org.example.producto.service;
import lombok.RequiredArgsConstructor;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.dto.command.ProductoCreateCommand;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoException;
import org.example.producto.model.exception.ProductoIlegalException;
import org.example.producto.port.dao.ProductoDao;
import org.example.producto.port.repository.ProductoRepository;
import java.math.BigDecimal;


@RequiredArgsConstructor
public class ProductoCreateService {
    private final ProductoRepository productoRepository;

    public Producto execute(ProductoCreateCommand productoCreateCommand){
        validarProducto(productoCreateCommand);
        Producto productoToCreate = new Producto().requestToCreate(productoCreateCommand);
        return productoRepository.create(productoToCreate);
    }

    //Metodos para realizar validaciones
    private void validarProducto(ProductoCreateCommand productoCreateCommand){
        if(productoCreateCommand.getNombre() == null || productoCreateCommand.getNombre().isBlank()){
            throw new ProductoIlegalException("El nombre del producto es obligatorio");
        }
        if(productoCreateCommand.getPrecio() == null || productoCreateCommand.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            throw new ProductoIlegalException("El precio es obligatorio y debe ser mayor a cero");
        }
        if(productoRepository.existsByName(productoCreateCommand.getNombre())){
            throw new ProductoException("Nombre de producto ingresado anteriormente");
        }

    }
}
