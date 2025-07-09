
package org.example.cliente.mapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "direccion", source = "direccion")
    ClienteDto toDto(Cliente domain);
}

