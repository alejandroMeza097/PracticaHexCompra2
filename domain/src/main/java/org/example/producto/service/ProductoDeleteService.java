package org.example.producto.service;

import lombok.RequiredArgsConstructor;
import org.example.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoDeleteService {
    private  final ProductoRepository productoRepository;

    public void execute(Long id){
        productoRepository.delete(id);
    }
}
