
package org.example.cliente.mapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    @Mapping(source = "id",target = "id")
    @Mapping(source = "nombre",target = "nombre")
    @Mapping(source = "apellido",target = "apellido")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "telefono",target = "telefono")
    @Mapping(source = "direccion",target = "direccion")
    ClienteDto toDto(Cliente domain);
}
