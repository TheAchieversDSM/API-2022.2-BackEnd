package com.api.crossSelling_Uol.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;
import com.api.crossSelling_Uol.services.ProdutoService;


@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@SuppressWarnings("unused")
	@Autowired
	private ProdutoRepository bancoProduto;
	
	@Autowired
	private ProdutoService servicoProduto;
	
	@GetMapping("/pegarProduto/{id}")
	public Optional<Produto> pegarProduto(@PathVariable String id ) {
		return servicoProduto.findById(id);
	}
	
	@GetMapping("/pegarTodosProdutos")
	public List<Produto> pegarTodosProdutos() {
		return servicoProduto.findAll();
	}
	
	@PostMapping("/criarProduto")
	public void criarProduto(@RequestBody Produto novoProduto) {
		servicoProduto.insert(novoProduto);
	}
	
	@PutMapping("/atualizarProduto")
	public void atualizarProduto(@RequestBody Produto produtoAtualizado) {
		servicoProduto.update(produtoAtualizado);
	}
}