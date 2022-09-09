package com.api.crossSelling_Uol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.PacoteRepository;

@Service

public class PacoteService {
	@Autowired
	private PacoteRepository bancoPacote;
	
	public Optional<Pacote> findById(String id) {
		return bancoPacote.findById(id);
	}
	
	public List<Pacote> findAll(){
		return bancoPacote.findAll();
	}
	
	public Pacote insert(Pacote novoPacote) {
		return bancoPacote.save(novoPacote);
	}
	
	public void update(Pacote pacoteAtualizado) {
		bancoPacote.deleteById(pacoteAtualizado.getId());
		bancoPacote.save(pacoteAtualizado);
	}
	
}
