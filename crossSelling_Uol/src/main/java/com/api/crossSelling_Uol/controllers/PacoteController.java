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

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.PacoteRepository;
import com.api.crossSelling_Uol.repositories.ProdutoRepository;
import com.api.crossSelling_Uol.services.PacoteService;
import com.api.crossSelling_Uol.services.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/pacotes")
public class PacoteController {
	@Autowired
	private PacoteService servicoPacote;
	
	@GetMapping("/pegarPacote/{id}")
	public Optional<Pacote> pegarPacote(@PathVariable String id ) {
		return servicoPacote.encontrarPeloId(id);
	}
	
	@GetMapping("/pegarTodosPacotes")
	public List<Pacote> pegarTodosPacotes() {
		return servicoPacote.encontrarTodos();
	}
	
	@PostMapping("/criarPacote")
	public void criarPacote(@RequestBody Pacote novoPacote) {
		servicoPacote.inserirPacote(novoPacote);
	}
	
	@PutMapping("/atualizarProduto")
	public void atualizarProduto(@RequestBody Pacote pacoteAtualizado) {
		servicoPacote.atualizarPacote(pacoteAtualizado);
	}
}
