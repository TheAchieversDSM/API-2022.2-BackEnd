package com.api.crossSelling_Uol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.crossSelling_Uol.models.Servico;

@Repository
public interface ServicoRepository extends MongoRepository<Servico, String>{

}
