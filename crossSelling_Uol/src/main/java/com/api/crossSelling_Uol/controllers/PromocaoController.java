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
import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.repositories.PacoteRepository;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;
import com.api.crossSelling_Uol.services.PacoteService;
import com.api.crossSelling_Uol.services.PromocaoService;

@CrossOrigin
@RestController
@RequestMapping("/promocoes")
public class PromocaoController {
	@Autowired
	@SuppressWarnings("unused")
	private PromocaoRepository bancoPromocao;
	
	@Autowired
	private PromocaoService servicoPromocao;
	
	@GetMapping("/pegarPromocao/{id}")
	public Optional<Promocao> pegarPromocao(@PathVariable String id ) {
		return servicoPromocao.findById(id);
	}
	
	@GetMapping("/pegarTodasPromocoes")
	public List<Promocao> pegarTodosProdutos() {
		return servicoPromocao.findAll();
	}
	
	@PostMapping("/criarPromocao")
	public void criarPacote(@RequestBody Promocao novaPromocao) {
		servicoPromocao.insert(novaPromocao);
	}
	
	@PutMapping("/atualizarPromocao")
	public void atualizarPromocao(@RequestBody Promocao promocaoAtualizada) {
		servicoPromocao.update(promocaoAtualizada);
	}
	
}
