package org.example.service;


import org.example.cliente.model.entity.Cliente;
import org.example.message.port.MessageRepository;
import org.example.producto.model.dto.command.ProductoCreateCommand;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoException;
import org.example.producto.model.exception.ProductoIlegalException;
import org.example.producto.port.repository.ProductoRepository;
import org.example.producto.service.ProductoCreateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductoCreateServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private ProductoCreateService productoCreateService;

    private ProductoCreateCommand productoCreateCommand;

    @Before
    public void setUp(){
        productoCreateCommand = new ProductoCreateCommand();
        productoCreateCommand.setNombre("Laptop");
        productoCreateCommand.setPrecio(BigDecimal.valueOf(123.6));
    }

    @Captor
    private ArgumentCaptor<Producto> productoCaptor;

    @Test
    public void executeCrearProducto(){
        when(productoRepository.existsByName(productoCreateCommand.getNombre())).thenReturn(false);
        when(productoRepository.create(any(Producto.class))).thenReturn(new Producto());

        productoCreateService.execute(productoCreateCommand);

        verify(productoRepository).create(productoCaptor.capture());

        Producto productoCreado = productoCaptor.getValue();

        assertEquals("Laptop",productoCreado.getNombre());
        assertEquals(BigDecimal.valueOf(123.6),productoCreado.getPrecio());

    }

    @Test(expected = ProductoIlegalException.class)
    public void productoNombre(){
        productoCreateCommand.setNombre(" ");
        productoCreateService.execute(productoCreateCommand);
    }

    @Test(expected = ProductoIlegalException.class)
    public void productoPrecio(){
        productoCreateCommand.setPrecio(BigDecimal.valueOf(-12.3));
        productoCreateService.execute(productoCreateCommand);
    }


}
