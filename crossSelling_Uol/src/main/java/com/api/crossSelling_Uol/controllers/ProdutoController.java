package com.api.crossSelling_Uol.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository bancoProduto;
	
	@GetMapping("/pegarProduto") //Esclarecer com Gerson sobre Get ou Post
	public Optional<Produto> pegarProduto(@RequestBody Produto produto) {
		return bancoProduto.findById(produto.getId());
	}
	
	@GetMapping("/pegarTodosProdutos")
	public List<Produto> pegarTodosProdutos(){
		return bancoProduto.findAll();
	}
	
	@PutMapping("/atualizarProduto")
	public void atualizarProduto(@RequestBody Produto produtoAtualizado) {
		bancoProduto.deleteById(produtoAtualizado.getId());
		bancoProduto.save(produtoAtualizado);
	}

	@PostMapping("/criarProduto")
	public void criarProduto(@RequestBody Produto novoProduto) {
		bancoProduto.save(novoProduto);
	}

}