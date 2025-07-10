package org.example.service;

import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.model.exception.ClienteIlegalInputException;
import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.ClienteCreateService;
import org.example.message.port.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ClienteCreateServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private ClienteCreateService clienteCreateService;

    private ClienteCreateCommand clienteCreateCommand;

    @Before
    public void setUp(){
        clienteCreateCommand = new ClienteCreateCommand();
        clienteCreateCommand.setNombre("Alex");
        clienteCreateCommand.setApellido("Meza");
        clienteCreateCommand.setEmail("alex.meza@gmail.com");
        clienteCreateCommand.setTelefono("5555");
        clienteCreateCommand.setDireccion("costa chica 431");
    }



    @Captor
    private ArgumentCaptor<Cliente> clienteCaptor;

    @Test
    public void executeCrearCliente(){
        when(clienteRepository.existsByEmail(clienteCreateCommand.getEmail())).thenReturn(false);
        when(clienteRepository.existsByNombre(clienteCreateCommand.getNombre())).thenReturn(false);
        when(clienteRepository.create(any(Cliente.class))).thenReturn(new Cliente());

        clienteCreateService.execute(clienteCreateCommand);

        verify(clienteRepository).create(clienteCaptor.capture());

        Cliente clienteCreado = clienteCaptor.getValue();

        assertEquals("Alex", clienteCreado.getNombre());
    }


    @Test(expected = ClienteIlegalInputException.class)
    public void nombreTestlienteIlegalInputException(){
        clienteCreateCommand.setNombre("  ");
        clienteCreateService.execute(clienteCreateCommand);
    }

    @Test(expected = ClienteIlegalInputException.class)
    public void apellidoTestlienteIlegalInputException(){
        clienteCreateCommand.setApellido("        ");
        clienteCreateService.execute(clienteCreateCommand);

    }
}
