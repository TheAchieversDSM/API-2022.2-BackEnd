package com.api.crossSelling_Uol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.crossSelling_Uol.models.Pacote;

public interface PacoteRepository extends MongoRepository <Pacote, String>  {
	
	@Query("{'servicos' :  { $elemMatch: { '_id' : ?0 } } }")
	List<Pacote> findPacotesByServ(String id);
}
