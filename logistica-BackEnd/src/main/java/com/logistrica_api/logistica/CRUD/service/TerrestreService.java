package com.logistrica_api.logistica.CRUD.service;

import com.logistrica_api.logistica.CRUD.dto.TerrestreDto;
import com.logistrica_api.logistica.CRUD.repository.TerrestreRepository;
import com.logistrica_api.logistica.CRUD.entity.Logistica_Terrestre;
import com.logistrica_api.logistica.global.exceptions.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class TerrestreService {
    @Autowired
    TerrestreRepository terrestreRepository;

    public List<Logistica_Terrestre> getAll() {
        return terrestreRepository.findAll();
    }
    public Logistica_Terrestre getOne(String numeroGuia) throws ResourceNotFoundException{
        return terrestreRepository.findByNumeroGuia(numeroGuia)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    public Logistica_Terrestre save(TerrestreDto dto) throws AttributeException {
        if (terrestreRepository.existsByNumeroGuia(dto.getNumeroGuia()))
            throw new AttributeException("Guide Number in use");
        int id = incremento();
        Logistica_Terrestre logisticaTerrestre = new Logistica_Terrestre(id,
                dto.getTipoProducto(),
                dto.getCantidadProducto(),
                dto.getFechaRegistro(),
                dto.getFechaEntrega(),
                dto.getBodegaEntrega(),
                dto.getPrecio(),
                dto.getPlacaVehiculo(),
                dto.getNumeroGuia(),
                dto.getDescuento(),
                dto.getPrecioDescuento()
        );
        return terrestreRepository.save(logisticaTerrestre);
    }

    public Logistica_Terrestre update(String numeroGuia, TerrestreDto dto) throws ResourceNotFoundException{
        Logistica_Terrestre logisticaTerrestre = terrestreRepository.findByNumeroGuia(numeroGuia)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        logisticaTerrestre.setBodegaEntrega(dto.getBodegaEntrega());
        logisticaTerrestre.setFechaEntrega(dto.getFechaEntrega());
        logisticaTerrestre.setPrecio(dto.getPrecio());
        logisticaTerrestre.setCantidadProducto(dto.getCantidadProducto());
        logisticaTerrestre.setTipoProducto(dto.getTipoProducto());
        logisticaTerrestre.setDescuento(dto.getDescuento());
        logisticaTerrestre.setPrecioDescuento(dto.getPrecioDescuento());
        return terrestreRepository.save(logisticaTerrestre);
    }


    public Logistica_Terrestre delete(String numeroGuia) throws ResourceNotFoundException{
        Logistica_Terrestre logisticaTerrestre = terrestreRepository.findByNumeroGuia(numeroGuia)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found"));
        terrestreRepository.delete(logisticaTerrestre);
        return  logisticaTerrestre;
    }

    // private methods
    private int incremento(){
        List<Logistica_Terrestre> logistica = terrestreRepository.findAll();
        return logistica.isEmpty()? 1 :
                logistica.stream().max(Comparator.comparing(Logistica_Terrestre::getId)).get().getId() + 1;
    }
}
