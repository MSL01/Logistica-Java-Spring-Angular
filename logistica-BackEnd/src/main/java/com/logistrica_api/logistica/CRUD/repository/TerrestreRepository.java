package com.logistrica_api.logistica.CRUD.repository;

import com.logistrica_api.logistica.CRUD.entity.Logistica_Terrestre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerrestreRepository extends MongoRepository<Logistica_Terrestre, Integer> {
    boolean existsByNumeroGuia(String numeroGuia);

    Optional<Logistica_Terrestre> findByNumeroGuia(String numeroGuia);
}
