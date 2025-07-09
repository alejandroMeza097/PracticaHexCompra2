package org.example.cliente.adapter.mapper;
import org.example.cliente.adapter.entity.ClienteEntity;
import org.example.cliente.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    // Convierte de entidad JPA a dominio
    public Cliente toDomain(ClienteEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    // Convierte de dominio a entidad JPA
    public ClienteEntity toEntity(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(cliente.getNombre());
        entity.setApellido(cliente.getApellido());
        entity.setEmail(cliente.getEmail());
        entity.setTelefono(cliente.getTelefono());
        entity.setDireccion(cliente.getDireccion());
        return entity;
    }
}
