package org.example.service;
import org.example.compra.model.dto.ProductoCantidadDto;
import org.example.compra.model.dto.command.VentaCreateComand;
import org.example.compra.model.entity.Venta;
import org.example.compra.port.dao.ClienteValidacionDao;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.compra.port.repository.VentaRepository;
import org.example.compra.service.VentaCreateService;
import org.example.producto.model.entity.Producto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VentaCreateServiceTest {

    @Mock
    private ClienteValidacionDao clienteValidacionDao;

    @Mock
    private ProductoValidacionDao productoValidacionDao;

    @Mock
    private VentaRepository ventaRepository;

    @Mock
    private ProductoDatosDao productoDatosDao;

    @InjectMocks
    private VentaCreateService ventaCreateService;

    private ProductoCantidadDto productoCantidadDto1;
    private ProductoCantidadDto productoCantidadDto2;
    private List<ProductoCantidadDto> listaProductos;
    private VentaCreateComand ventaCreateComand;



    @Before
    public void setUp(){
        productoCantidadDto1 = new ProductoCantidadDto();
        productoCantidadDto2 = new ProductoCantidadDto();
        ventaCreateComand = new VentaCreateComand();
        listaProductos = new ArrayList<>();

        productoCantidadDto1.setProductoId(1L);
        productoCantidadDto1.setCantidad(10);

        productoCantidadDto2.setProductoId(2L);
        productoCantidadDto2.setCantidad(14);

        listaProductos.add(productoCantidadDto1);
        listaProductos.add(productoCantidadDto2);

        ventaCreateComand.setClienteId(1L);
        ventaCreateComand.setProductos(listaProductos);
    }


    @Captor
    private ArgumentCaptor<Venta> ventaCaptor;

    @Test
    public void createVentaTest(){


        when(clienteValidacionDao.existeCliente(ventaCreateComand.getClienteId())).thenReturn(true);
        when(productoValidacionDao.existeProducto(productoCantidadDto1.getProductoId())).thenReturn(true);
        when(productoValidacionDao.existeProducto(productoCantidadDto2.getProductoId())).thenReturn(true);

        Producto producto1 = new Producto(1L,"Tablet", BigDecimal.valueOf(12.3));
        Producto producto2 = new Producto(2L,"Lapto",BigDecimal.valueOf(145.6));

        when(productoDatosDao.obtenerDatos(productoCantidadDto1.getProductoId())).thenReturn(producto1);
        when(productoDatosDao.obtenerDatos(productoCantidadDto2.getProductoId())).thenReturn(producto2);

        Venta ventaMock = new Venta();
        when(ventaRepository.guardarVenta(any(Venta.class))).thenReturn(ventaMock);

        Venta ventaReal = ventaCreateService.execute(ventaCreateComand);

        assertNotNull(ventaReal);
        verify(clienteValidacionDao).existeCliente(1L);
        verify(productoValidacionDao).existeProducto(1L);
        verify(productoValidacionDao).existeProducto(2L);
        verify(productoDatosDao).obtenerDatos(1L);
        verify(productoDatosDao).obtenerDatos(2L);

        verify(ventaRepository).guardarVenta(ventaCaptor.capture());

        Venta ventaCapturada = ventaCaptor.getValue();
        assertEquals(1L, ventaCapturada.getClienteId().longValue());
        assertEquals(2, ventaCapturada.getProductos().size());
        assertEquals(new BigDecimal("2161.4"), ventaCapturada.getPrecioTotal());

    }

}
