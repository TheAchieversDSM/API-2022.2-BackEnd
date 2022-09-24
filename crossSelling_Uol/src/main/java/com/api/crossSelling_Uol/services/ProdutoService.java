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
	
	
	public List<Produto> encontrarExcetoComplementos(String id){
		Produto alvo = bancoProduto.findById(id).orElse(null);
		List<Produto> produtos = bancoProduto.findAll();
		for (int i = 0; i < alvo.getComplementares().size() ; i++) {
			Produto complemento = bancoProduto.findById(alvo.getComplementares().get(i).getId()).orElse(null); 
			produtos.remove(complemento);
		}
		produtos.remove(alvo);
		return produtos;
	}
	
	public void inserirProduto(Produto novoProduto) {
		String produtoId = bancoProduto.save(novoProduto).getId();

		if(novoProduto.getComplementares().size() > 0) {
			for (int i = 0; i < novoProduto.getComplementares().size() ; i++) {
					Produto produtoAdicionar = new Produto();
					produtoAdicionar.setId(produtoId);
					produtoAdicionar.setNome(novoProduto.getNome());
					System.out.print(produtoAdicionar);
					Produto complemento = bancoProduto.findById(novoProduto.getComplementares().get(i).getId()).orElse(null); 				
					complemento.getComplementares().add(produtoAdicionar);
					bancoProduto.save(complemento);
				}
		}
		
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
