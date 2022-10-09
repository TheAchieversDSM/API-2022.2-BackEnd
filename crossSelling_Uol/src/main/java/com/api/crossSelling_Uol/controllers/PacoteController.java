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
import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.services.PacoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/pacotes")
@Api(value="Pacotes")
public class PacoteController {
	@Autowired
	private PacoteService servicoPacote;
	
	@ApiOperation("Pegar pacote existente pelo ID")
	@GetMapping("/pegarPacote/{id}")
	public Optional<Pacote> pegarPacote(@PathVariable String id ) {
		return servicoPacote.encontrarPeloId(id);
	}
	
	@ApiOperation("Pegar todos os pacotes existentes")
	@GetMapping("/pegarTodosPacotes")
	public List<Pacote> pegarTodosPacotes() {
		return servicoPacote.encontrarTodos();
	}
	
	@ApiOperation("Pegar todos os serviços pelo pacote que o engloba")
	@PostMapping("/pegarServicos")
	public List<Servico> pegarTodosServicosPeloPacote(@RequestBody Pacote pacote ){
		return servicoPacote.encontrarServicosPeloPacote(pacote);
	}
	
	@ApiOperation("Criar novo pacote")
	@PostMapping("/criarPacote")
	public void criarPacote(@RequestBody Pacote novoPacote) {
		servicoPacote.inserirPacote(novoPacote);
	}
	
	@ApiOperation("Atualizar pacote já existente")
	@PutMapping("/atualizarPacote")
	public void atualizarPacote(@RequestBody Pacote pacoteAtualizado) {
		servicoPacote.atualizarPacote(pacoteAtualizado);
	}
}
