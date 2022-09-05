package com.api.crossSelling_Uol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;

@RestController
public class PromocaoController {
	@Autowired
	private PromocaoRepository bancoPromocao;

	@GetMapping("/promocoes")
	public List<Promocao> pegarPromocoes(){
		return bancoPromocao.findAll();
	}

	@PostMapping("/promocaoCriar")
	public void criarPromocao(@RequestBody Promocao novaPromocao) {
		bancoPromocao.save(novaPromocao);
	}
	
	
}
