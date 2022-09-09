package com.api.crossSelling_Uol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository bancoServico;
	
	public Optional<Servico> findById(String id) {
		return bancoServico.findById(id);
	}
	
	public List<Servico> findAll(){
		return bancoServico.findAll();
	}

	public Servico insert(Servico novoServico) {
		return bancoServico.save(novoServico);
	}

	public void update(Servico servicoAtualizado) {
		bancoServico.deleteById(servicoAtualizado.getId());
		bancoServico.save(servicoAtualizado);
	}
}
