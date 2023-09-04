package com.logistrica_api.logistica.CRUD.controller;

import com.logistrica_api.logistica.CRUD.dto.MaritimoDto;
import com.logistrica_api.logistica.CRUD.entity.Logistica_maritima;
import com.logistrica_api.logistica.CRUD.service.MartitimoService;
import com.logistrica_api.logistica.global.dto.MessageDto;
import com.logistrica_api.logistica.global.exceptions.AttributeException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maritima")
@CrossOrigin
public class MaritimoController {
    @Autowired
    MartitimoService martitimoService;

    @GetMapping
    public ResponseEntity<List<Logistica_maritima>> getAll() { return ResponseEntity.ok(martitimoService.getAll()); }

    @GetMapping("/{numeroGuia}")
    public ResponseEntity<Logistica_maritima> getOne(@PathVariable("numeroGuia") String numeroGuia) throws ResourceNotFoundException {
        return ResponseEntity.ok(martitimoService.getOne(numeroGuia));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody MaritimoDto dto) throws AttributeException {
        Logistica_maritima logisticaMaritima = martitimoService.save(dto);
        String message = "Maritimo" + logisticaMaritima.getNumeroGuia() + "Creada";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{numeroGuia}")
    public ResponseEntity<MessageDto> update(@PathVariable("numeroGuia") String numeroGuia, @Valid @RequestBody MaritimoDto dto) throws ResourceNotFoundException{
        Logistica_maritima logisticaMaritima = martitimoService.update(numeroGuia, dto);
        String message = "Maritimo" + logisticaMaritima.getNumeroGuia() + "Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{numeroGuia}")
    public ResponseEntity<MessageDto> delete(@PathVariable("numeroGuia") String numeroGuia) throws  ResourceNotFoundException{
        Logistica_maritima logisticaMaritima = martitimoService.delete(numeroGuia);
        String message = "Maritimo" + logisticaMaritima.getNumeroGuia() + "Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
