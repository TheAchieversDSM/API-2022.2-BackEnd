package com.api.crossSelling_Uol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.repositories.PacoteRepository;
@RestController
public class PacoteController {
	@Autowired
	private PacoteRepository bancoPacote;
	
	@GetMapping("/pacotes")
	public List<Pacote> pegarPacote(){
		return bancoPacote.findAll();
	}
	
	@PostMapping("/criarPacote")
	public void criarPacote(@RequestBody Pacote novoPacote) {
		bancoPacote.save(novoPacote);
	}
}
