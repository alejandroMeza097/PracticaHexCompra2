package org.example.producto.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.dto.command.ProductoCreateCommand;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.repository.ProductoRepository;


@RequiredArgsConstructor
public class ProductoCreateService {
    private final ProductoRepository productoRepository;
    public Producto execute(ProductoCreateCommand productoCreateCommand){
        Producto productoToCreate = new Producto().requestToCreate(productoCreateCommand);
        return productoRepository.create(productoToCreate);
    }
}
