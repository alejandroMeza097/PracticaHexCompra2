package org.example.cliente.adapter.mapper;

import org.example.cliente.adapter.entity.ClienteEntity;
import org.example.cliente.model.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toDomain(ClienteEntity entity);
    ClienteEntity toEntity(Cliente cliente);
}
