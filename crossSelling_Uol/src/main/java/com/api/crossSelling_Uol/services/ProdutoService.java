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
	
	public Optional<Produto> encontrarPeloId(String id) {
		return bancoProduto.findById(id);
	}
	
	public List<Produto> encontrarTodos(){
		return bancoProduto.findAll();
	}
	
	public Produto inserirProduto(Produto novoProduto) {
		return bancoProduto.save(novoProduto);
	}
	
	public void atualizarProduto(Produto produtoAtualizado) {
		bancoProduto.save(produtoAtualizado);
	}
	
	public void atualizarComplementos( List<Produto> complemento, String id ) {
		Produto alvo = bancoProduto.findById(id).orElse(null);
		alvo.getComplementares().addAll(complemento);
		bancoProduto.save(alvo);
		
	}
	
	
}
