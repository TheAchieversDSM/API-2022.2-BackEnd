package com.api.crossSelling_Uol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.crossSelling_Uol.models.Promocao;

public interface PromocaoRepository extends MongoRepository <Promocao, String> {

}
