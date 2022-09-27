package com.api.crossSelling_Uol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.crossSelling_Uol.models.Promocao;

public interface PromocaoRepository extends MongoRepository <Promocao, String> {
	
	@Query("{'pacotes' :  { $elemMatch: { '_id' : ?0 } } }")
	List<Promocao> findPromocoesByPack(String id);

}
