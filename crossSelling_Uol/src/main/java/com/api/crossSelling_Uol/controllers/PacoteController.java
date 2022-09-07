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

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.repositories.PacoteRepository;


@RestController
@RequestMapping("/pacotes")
public class PacoteController {
	@Autowired
	private PacoteRepository bancoPacote;
	
	
	@GetMapping("/pegarPacote") 
	public Optional<Pacote> pegarPacote(@RequestBody Pacote pacote) {
		return bancoPacote.findById(pacote.getId());
	}	
	
	@GetMapping("/pegarTodosPacotes")
	public List<Pacote> pegarPacote(){
		return bancoPacote.findAll();
	}
	
	@PutMapping("/atualizarPacote")
	public void atualizarPacote(@RequestBody Pacote pacoteAtualizado) {
		bancoPacote.deleteById(pacoteAtualizado.getId());
		bancoPacote.save(pacoteAtualizado);
	}
	
	@PostMapping("/criarPacote")
	public void criarPacote(@RequestBody Pacote novoPacote) {
		bancoPacote.save(novoPacote);
	}
}
