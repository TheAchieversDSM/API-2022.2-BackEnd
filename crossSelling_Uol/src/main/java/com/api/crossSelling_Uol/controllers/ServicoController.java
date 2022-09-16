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

import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.ServicoRepository;
import com.api.crossSelling_Uol.services.ServicoService;

@CrossOrigin
@RestController
@RequestMapping("/servicos")
public class ServicoController {
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/pegarServico/{id}")
	public Optional<Servico> pegarServico(@PathVariable String id) {
		return servicoService.encontrarPeloId(id);
	}
	
	@GetMapping("/pegarTodosServicos")
	public List<Servico> pegarTodosServicos() {
		return servicoService.encontrarTodos();
	}
	
	@PostMapping("/criarServico")
	public void criarServico(@RequestBody Servico novoServico) {
		servicoService.inserirServico(novoServico);
	}
	
	@PutMapping("/atualizarServico")
	public void atualizarServico(@RequestBody Servico servicoAtualizado) {
		servicoService.atualizarServico(servicoAtualizado);
	}
	
}