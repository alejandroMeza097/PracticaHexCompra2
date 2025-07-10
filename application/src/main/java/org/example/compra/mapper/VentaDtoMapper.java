package org.example.compra.mapper;


import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.example.compra.model.dto.VentaDto;
import org.example.compra.model.entity.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "clienteId", source = "clienteId")
    @Mapping(target = "productos", source = "productos")
    @Mapping(target = "precioTotal", source = "precioTotal")
    @Mapping(target = "fechaCompra", source = "fechaCompra")
    VentaDto toDto(Venta domain);

}
