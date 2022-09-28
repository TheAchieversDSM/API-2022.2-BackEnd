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
import com.api.crossSelling_Uol.services.ServicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/servicos")
@Api(value="Serviços")
public class ServicoController {
	@Autowired
	private ServicoService servicoService;
	
	@ApiOperation("Pegar serviço existente pelo ID")
	@GetMapping("/pegarServico/{id}")
	public Optional<Servico> pegarServico(@PathVariable String id) {
		return servicoService.encontrarPeloId(id);
	}
	
	@ApiOperation("Pegar todos os serviços existentes")
	@GetMapping("/pegarTodosServicos")
	public List<Servico> pegarTodosServicos() {
		return servicoService.encontrarTodos();
	}
	
	@ApiOperation("Pegar todos os serviços existentes exceto os complementos do serviço informado")
	@GetMapping("/pegarTodosExcetoComplementos/{id}")
	public List<Servico> pegarTodosExcetoComplementos(@PathVariable String id) {
		return servicoService.encontrarExcetoComplementos(id);
	}
	
	@ApiOperation("Pegar todos os serviços pelos produtos que o compoem")
	@GetMapping("/pegarTodosServicosPeloProduto/{id}")
	public List<Servico> pegarTodosServicosPeloProduto(@PathVariable String id) {
		return servicoService.encontrarServicosPeloProduto(id);
	}
	
	@ApiOperation("Pegar todos os complementares de um serviço")
	@GetMapping("/todosComplementos/{id}")
	public List<Servico> pegarComplementos(@PathVariable String id )  {
		return servicoService.pegarComplementos(id);
	}
	
	@ApiOperation("Criar novo serviço")
	@PostMapping("/criarServico")
	public void criarServico(@RequestBody Servico novoServico) {
		servicoService.inserirServico(novoServico);
	}
	
	@ApiOperation("Atualizar serviço já existente")
	@PutMapping("/atualizarServico")
	public void atualizarServico(@RequestBody Servico servicoAtualizado) {
		servicoService.atualizarServico(servicoAtualizado);
	}
	
	@ApiOperation("Adicionar novo serviço complementar a um serviço já existente")
	@PutMapping("/atualizarComplementos/{id}")
	public void atualizarComplementos(@RequestBody List<Servico> complemento, @PathVariable String id ) {
		servicoService.atualizarComplementos(complemento, id);
	}
	
}