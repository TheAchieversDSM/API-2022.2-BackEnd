package com.api.crossSelling_Uol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.crossSelling_Uol.models.Oferta;

public interface OfertaRepository extends MongoRepository<Oferta, String> {

}
