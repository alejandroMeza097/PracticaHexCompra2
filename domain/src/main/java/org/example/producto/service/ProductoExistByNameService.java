package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoExistByNameService {
    private  final ProductoRepository productoRepository;
    public boolean execute(String nombre){
        return productoRepository.existsByName(nombre);
    }
}
