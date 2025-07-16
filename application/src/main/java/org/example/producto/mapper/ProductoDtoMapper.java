package org.example.producto.mapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "stock",source = "stock")
    ProductoDto toDto(Producto domain);
}
