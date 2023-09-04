package com.logistrica_api.logistica.CRUD.service;

import com.logistrica_api.logistica.CRUD.dto.MaritimoDto;
import com.logistrica_api.logistica.CRUD.entity.Logistica_Terrestre;
import com.logistrica_api.logistica.CRUD.entity.Logistica_maritima;
import com.logistrica_api.logistica.CRUD.repository.MaritimaRepository;
import com.logistrica_api.logistica.global.exceptions.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class MartitimoService {
    @Autowired
    MaritimaRepository maritimaRepository;

    public List<Logistica_maritima> getAll() { return maritimaRepository.findAll(); }
    public Logistica_maritima getOne(String numeroGuia) throws ResourceNotFoundException {
        return maritimaRepository.findByNumeroGuia(numeroGuia)
            .orElseThrow(() -> new ResourceNotFoundException("Not Found")); }

    public Logistica_maritima save(MaritimoDto dto) throws AttributeException {
        if (maritimaRepository.existsByNumeroGuia(dto.getNumeroGuia()))
            throw new AttributeException("Guide number in use");
        int id = incremento();
        Logistica_maritima logisticaMaritima = new Logistica_maritima(
                id,
                dto.getTipoProducto(),
                dto.getCantidadProducto(),
                dto.getFechaRegistro(),
                dto.getFechaEntrega(),
                dto.getPuertoEntrega(),
                dto.getPrecio(),
                dto.getNumeroFlota(),
                dto.getNumeroGuia(),
                dto.getDescuento(),
                dto.getPrecioDescuento()
        );
        return maritimaRepository.save(logisticaMaritima);
    }

    public Logistica_maritima update(String numeroGuia, MaritimoDto dto) throws ResourceNotFoundException{
        Logistica_maritima logisticaMaritima = maritimaRepository.findByNumeroGuia(numeroGuia)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found"));
        logisticaMaritima.setCantidadProducto(dto.getCantidadProducto());
        logisticaMaritima.setFechaEntrega(dto.getFechaEntrega());
        logisticaMaritima.setPuertoEntrega(dto.getPuertoEntrega());
        logisticaMaritima.setPrecio(dto.getPrecio());
        logisticaMaritima.setTipoProducto(dto.getTipoProducto());
        logisticaMaritima.setDescuento(dto.getDescuento());
        logisticaMaritima.setPrecioDescuento(dto.getPrecioDescuento());
        return maritimaRepository.save(logisticaMaritima);
    }

    public Logistica_maritima delete(String numeroGuia) throws ResourceNotFoundException{
        Logistica_maritima logisticaMaritima = maritimaRepository.findByNumeroGuia(numeroGuia)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found"));
        maritimaRepository.delete(logisticaMaritima);
        return logisticaMaritima;
    }
    // Private Method

    private int incremento(){
        List<Logistica_maritima> logistica = maritimaRepository.findAll();
        return logistica.isEmpty()? 1:
                logistica.stream().max(Comparator.comparing(Logistica_maritima::getId)).get().getId() + 1;
    }
}
