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
	
	public void  inserirProduto(Produto novoProduto) {
		bancoProduto.save(novoProduto);
	}
	
	public Optional<Produto> encontrarPeloId(String id) {
		return bancoProduto.findById(id);
	}
	
	public List<Produto> encontrarTodos(){
		return bancoProduto.findAll();
	}
		
	public void atualizarProduto(Produto produtoAtualizado) {
		bancoProduto.save(produtoAtualizado);
	}


}
