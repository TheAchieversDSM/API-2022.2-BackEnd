package com.api.crossSelling_Uol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.ServicoRepository;

@RestController
public class ServicoController {
	@Autowired
	private ServicoRepository bancoServico;
	
	@GetMapping("/servicos")
	public List<Servico> pegarServico(){
		return bancoServico.findAll();
	}
	
	@PostMapping("/criarServico")
	public void criarProduto(@RequestBody Servico novoProduto) {
		bancoServico.save(novoProduto);
	}
	
}
