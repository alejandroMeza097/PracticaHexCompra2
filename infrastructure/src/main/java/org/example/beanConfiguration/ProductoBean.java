package org.example.beanConfiguration;

import org.example.cliente.port.dao.ClienteDao;
import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.*;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.message.port.MessageRepository;
import org.example.producto.port.dao.ProductoDao;
import org.example.producto.port.repository.ProductoRepository;
import org.example.producto.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoBean {

    @Bean
    public ProductoCreateService productoCreateService(ProductoRepository productoRepository, MessageRepository messageRepository) {
        return new ProductoCreateService(productoRepository,messageRepository);
    }

    @Bean
    public ProductoAllService productoAllService(ProductoDao productoDao){
        return new ProductoAllService(productoDao);
    }

    @Bean
    public ProductoByIdService productoByIdService(ProductoDao productoDao, ProductoValidacionDao productoValidacionDao){
        return new ProductoByIdService(productoDao, productoValidacionDao);
    }

    @Bean
    public ProductoDeleteService productoDeleteService(ProductoRepository productoRepository) {
        return new ProductoDeleteService(productoRepository);
    }
    @Bean
    public ProductoUpdateService productoUpdateService(ProductoRepository productoRepository) {
        return new ProductoUpdateService(productoRepository);
    }

    @Bean ProductoExistByNameService productoExistByNameService(ProductoRepository productoRepository){
        return new ProductoExistByNameService(productoRepository);
    }

}
