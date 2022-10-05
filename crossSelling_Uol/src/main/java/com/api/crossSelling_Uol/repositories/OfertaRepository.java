package com.api.crossSelling_Uol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.crossSelling_Uol.models.Oferta;

public interface OfertaRepository extends MongoRepository<Oferta, String> {
	
	@Query("{'pacote._id' : ?0 }")
	List<Oferta> findOfertaByPack(String id);
}
