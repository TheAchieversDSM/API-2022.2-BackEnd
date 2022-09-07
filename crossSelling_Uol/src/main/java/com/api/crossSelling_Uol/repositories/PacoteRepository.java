package com.api.crossSelling_Uol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.crossSelling_Uol.models.Pacote;

public interface PacoteRepository extends MongoRepository <Pacote, String>  {

}
