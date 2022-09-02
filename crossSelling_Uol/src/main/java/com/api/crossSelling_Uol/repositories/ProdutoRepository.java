package com.api.crossSelling_Uol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.crossSelling_Uol.models.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
