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

import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {
	@Autowired
	private PromocaoRepository bancoPromocao;

	@GetMapping("/pegarTodasPromocoes")
	public List<Promocao> pegarPromocoes(){
		return bancoPromocao.findAll();
	}
	
	@GetMapping("/pegarPromocao") 
	public Optional<Promocao> pegarPromocao(@RequestBody Promocao promocao) {
		return bancoPromocao.findById(promocao.getId());
	}
	
	@PutMapping("/atualizarPromocao")
	public void atualizarPacote(@RequestBody Promocao promocaoAtualizada) {
		bancoPromocao.deleteById(promocaoAtualizada.getId());
		bancoPromocao.save(promocaoAtualizada);
	}

	@PostMapping("/criarPromocao")
	public void criarPromocao(@RequestBody Promocao novaPromocao) {
		bancoPromocao.save(novaPromocao);
	}
	
	
}
