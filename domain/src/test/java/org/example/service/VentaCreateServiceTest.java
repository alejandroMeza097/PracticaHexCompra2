package org.example.service;

import org.example.compra.port.dao.ClienteValidacionDao;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.compra.port.repository.VentaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VentaCreateServiceTest {

    @Mock
    private ClienteValidacionDao clienteValidacionDao;

    @Mock
    private ProductoValidacionDao productoValidacionDao;

    @Mock
    private VentaRepository ventaRepository;


    @Test
    public void createVentaTest(){

    }

}
