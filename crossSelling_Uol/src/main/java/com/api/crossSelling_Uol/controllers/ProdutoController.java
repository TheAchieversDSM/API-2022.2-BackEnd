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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;
import com.api.crossSelling_Uol.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/produtos")
@Api(value="Produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService servicoProduto;
	
	@ApiOperation("Pegar produto existente pelo ID")
	@GetMapping("/pegarProduto/{id}")
	public Optional<Produto> pegarProduto(@PathVariable String id ) {
		return servicoProduto.encontrarPeloId(id);
	}
	
	@ApiOperation("Pegar todos os produtos existentes")
	@GetMapping("/pegarTodosProdutos")
	public List<Produto> pegarTodosProdutos() {
		return servicoProduto.encontrarTodos();
	}
	
	@ApiOperation("Criar novo produto")
	@PostMapping("/criarProduto")
	public void criarProduto(@RequestBody Produto novoProduto) {
		servicoProduto.inserirProduto(novoProduto);
	}
	
	@ApiOperation("Atualizar produto já existente")
	@PutMapping("/atualizarProduto")
	public void atualizarProduto(@RequestBody Produto produtoAtualizado) {
		servicoProduto.atualizarProduto(produtoAtualizado);
	}
	
	@ApiOperation("Adicionar novo produto complementar a um produto já existente")
	@PutMapping("/atualizarComplementos/{id}")
	public void atualizarComplementos(@RequestBody List<Produto> complemento, @PathVariable String id ) {
		servicoProduto.atualizarComplementos(complemento, id);
	}
}