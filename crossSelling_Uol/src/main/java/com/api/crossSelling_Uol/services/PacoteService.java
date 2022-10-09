package com.api.crossSelling_Uol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.PacoteRepository;

@Service

public class PacoteService {
	@Autowired
	private PacoteRepository bancoPacote;
	
	public Optional<Pacote> encontrarPeloId(String id) {
		return bancoPacote.findById(id);
	}
	
	public List<Pacote> encontrarTodos(){
		return bancoPacote.findAll();
	}
	
	public List<Servico> encontrarServicosPeloPacote(Pacote pacote){
		Pacote pack = bancoPacote.findById(pacote.getId()).orElse(null);
		return pack.getServicos();
	}
	
	public List<Pacote> encontrarPacotesPeloServico(List<Servico> servicos){
		List<Pacote> pacotes = new ArrayList();
		for (int i = 0; i < servicos.size() ; i++) {
			pacotes.addAll(bancoPacote.findPacotesByServ(servicos.get(i).getId()));
		}
		return pacotes;
		
	}
	
	public Pacote inserirPacote(Pacote novoPacote) {
		return bancoPacote.save(novoPacote);
	}
	
	public void atualizarPacote(Pacote pacoteAtualizado) {
		bancoPacote.save(pacoteAtualizado);
	}
	
}
