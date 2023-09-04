package com.logistrica_api.logistica.CRUD.repository;

import com.logistrica_api.logistica.CRUD.entity.Logistica_Terrestre;
import com.logistrica_api.logistica.CRUD.entity.Logistica_maritima;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaritimaRepository extends MongoRepository<Logistica_maritima, Integer> {
    boolean existsByNumeroGuia(String NumeroGuia);

    Optional<Logistica_maritima> findByNumeroGuia(String numeroGuia);
}
