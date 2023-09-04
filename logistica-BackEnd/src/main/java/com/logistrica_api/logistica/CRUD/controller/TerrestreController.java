package com.logistrica_api.logistica.CRUD.controller;


import com.logistrica_api.logistica.CRUD.dto.TerrestreDto;
import com.logistrica_api.logistica.CRUD.service.TerrestreService;
import com.logistrica_api.logistica.CRUD.entity.Logistica_Terrestre;
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
@RequestMapping("/terrestre")
@CrossOrigin
public class TerrestreController {
    @Autowired
    TerrestreService terrestreService;
    @GetMapping
    public ResponseEntity<List<Logistica_Terrestre>> getAll() {
        return ResponseEntity.ok(terrestreService.getAll());
    }

    @GetMapping("/{numeroGuia}")
    public ResponseEntity<Logistica_Terrestre> getOne(@PathVariable("numeroGuia") String numeroGuia) throws ResourceNotFoundException {
        return ResponseEntity.ok(terrestreService.getOne(numeroGuia));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody TerrestreDto dto) throws AttributeException {
        Logistica_Terrestre logisticaTerrestre = terrestreService.save(dto);
        String messsage = "Terrestre " + logisticaTerrestre.getNumeroGuia() + "creada";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, messsage));
    }

    @PutMapping("/{numeroGuia}")
    public ResponseEntity<MessageDto> update(@PathVariable("numeroGuia") String numeroGuia, @Valid @RequestBody TerrestreDto dto) throws ResourceNotFoundException{
        Logistica_Terrestre logisticaTerrestre = terrestreService.update(numeroGuia, dto);
        String messsage = "Terrestre " + logisticaTerrestre.getNumeroGuia() + "Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, messsage));
    }

    @DeleteMapping("/{numeroGuia}")
    public ResponseEntity<MessageDto> delete(@PathVariable("numeroGuia") String numeroGuia) throws ResourceNotFoundException {
        Logistica_Terrestre logisticaTerrestre = terrestreService.delete(numeroGuia);
        String messsage = "Terrestre " + logisticaTerrestre.getNumeroGuia() + "Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, messsage));
    }

}
