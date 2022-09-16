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
	
	public Optional<Servico> encontrarPeloId(String id) {
		return bancoServico.findById(id);
	}
	
	public List<Servico> encontrarTodos(){
		return bancoServico.findAll();
	}

	public Servico inserirServico(Servico novoServico) {
		return bancoServico.save(novoServico);
	}

	public void atualizarServico(Servico servicoAtualizado) {
		bancoServico.save(servicoAtualizado);
	}
}
