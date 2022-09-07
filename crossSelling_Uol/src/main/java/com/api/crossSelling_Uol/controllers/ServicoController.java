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

import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
	@Autowired
	private ServicoRepository bancoServico;
	
	@GetMapping("/pegarServico") //Esclarecer com Gerson sobre Get ou Post
	public Optional<Servico> pegarProduto(@RequestBody Servico servico) {
		return bancoServico.findById(servico.getId());
	}
	
	@GetMapping("/pegarTodosServicos")
	public List<Servico> pegarTodosServicos(){
		return bancoServico.findAll();
	}
	
	@PutMapping("/atualizarServico")
	public void atualizarProduto(@RequestBody Servico servicoAtualizado) {
		bancoServico.deleteById(servicoAtualizado.getId());
		bancoServico.save(servicoAtualizado);
	}
	
	@PostMapping("/criarServico")
	public void criarProduto(@RequestBody Servico novoServico) {
		bancoServico.save(novoServico);
	}
	
}