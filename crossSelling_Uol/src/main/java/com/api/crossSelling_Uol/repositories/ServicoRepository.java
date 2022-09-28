package com.api.crossSelling_Uol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crossSelling_Uol.models.Servico;

@Repository
public interface ServicoRepository extends MongoRepository<Servico, String>{
	
	@Query("{'produtos' :  { $elemMatch: { '_id' : ?0 } } }")
	List<Servico> findServicosByProd(String id);
	
	@Query("{'categoria' : ?0 }")
	List<Servico> findServicosByCate(String categoria);
}

