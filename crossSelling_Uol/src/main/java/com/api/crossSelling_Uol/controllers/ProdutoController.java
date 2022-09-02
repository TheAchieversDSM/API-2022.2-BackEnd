package com.api.crossSelling_Uol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;

@RestController
public class ProdutoController {
	@Autowired
	private ProdutoRepository bancoProduto;
	
	@GetMapping("/produtos")
	public List<Produto> pegarProdutos(){
		return bancoProduto.findAll();
	}
	
	@PostMapping("/criar")
	public void criarProduto(@RequestBody Produto novoProduto) {
		bancoProduto.save(novoProduto);
	}

}
