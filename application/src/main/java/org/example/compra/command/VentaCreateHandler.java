package org.example.compra.command;

import lombok.RequiredArgsConstructor;
import org.example.compra.mapper.VentaDtoMapper;
import org.example.compra.model.dto.VentaDto;
import org.example.compra.model.dto.command.VentaCreateComand;
import org.example.compra.service.VentaCreateService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VentaCreateHandler {

    private final VentaCreateService ventaCreateService;
    private final VentaDtoMapper ventaDtoMapper;

    public VentaDto execute(VentaCreateComand ventaCreateComand){
        return ventaDtoMapper.toDto(ventaCreateService.execute(ventaCreateComand));
    }
}
