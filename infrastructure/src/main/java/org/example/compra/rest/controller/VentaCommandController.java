package org.example.compra.rest.controller;


import lombok.RequiredArgsConstructor;
import org.example.compra.adapter.entiy.VentaEntity;
import org.example.compra.adapter.mapper.VentaMapper;
import org.example.compra.command.VentaCreateHandler;
import org.example.compra.model.dto.VentaDto;
import org.example.compra.model.dto.command.VentaCreateComand;
import org.example.compra.model.entity.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping("/venta")
public class VentaCommandController {
    private final VentaCreateHandler ventaCreateHandler;
    private final VentaMapper ventaMapper;
    @PostMapping
    public ResponseEntity<VentaDto> crearVenta(@RequestBody VentaCreateComand ventaCreateComand){
        VentaDto venta = ventaCreateHandler.execute(ventaCreateComand);
        return  ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }


}
