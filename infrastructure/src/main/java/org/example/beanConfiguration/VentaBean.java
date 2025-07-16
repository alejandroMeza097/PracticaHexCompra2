package org.example.beanConfiguration;

import org.example.compra.port.dao.ClienteValidacionDao;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.compra.port.repository.VentaRepository;
import org.example.compra.service.ClienteValidacionService;
import org.example.compra.service.ProductoDatosService;
import org.example.compra.service.ProductoValidacionService;
import org.example.compra.service.VentaCreateService;
import org.example.producto.service.ProductoByIdService;
import org.example.producto.service.ProductoUpdateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentaBean {

    @Bean
    public VentaCreateService ventaCreateService(ClienteValidacionDao clienteValidacionDao,
                                                 ProductoValidacionDao productoValidacionDao,
                                                 ProductoDatosDao productoDatosDao,
                                                 VentaRepository ventaRepository,
                                                 ProductoByIdService productoByIdService,
                                                 ProductoUpdateService productoUpdateService){

        return  new VentaCreateService(clienteValidacionDao,productoValidacionDao,ventaRepository,productoDatosDao,productoByIdService,productoUpdateService);

    }
    @Bean
    public ClienteValidacionService clienteValidacionService(ClienteValidacionDao clienteValidacionDao){
        return new ClienteValidacionService(clienteValidacionDao);
    }

    @Bean
    public ProductoDatosService productoDatosService(ProductoDatosDao productoDatosDao){
        return new ProductoDatosService(productoDatosDao);
    }

    public ProductoValidacionService productoValidacionService(ProductoValidacionDao productoValidacionDao){
        return new ProductoValidacionService(productoValidacionDao);
    }
}
