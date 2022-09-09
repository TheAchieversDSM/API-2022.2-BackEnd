package com.api.crossSelling_Uol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository bancoProduto;
	
	public Optional<Produto> findById(String id) {
		return bancoProduto.findById(id);
	}
	
	public List<Produto> findAll(){
		return bancoProduto.findAll();
	}
	
	public Produto insert(Produto novoProduto) {
		return bancoProduto.save(novoProduto);
	}
	
	public void update(Produto produtoAtualizado) {
		bancoProduto.deleteById(produtoAtualizado.getId());
		bancoProduto.save(produtoAtualizado);
	}
	
	
}
