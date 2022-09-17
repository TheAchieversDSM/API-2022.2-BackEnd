package com.api.crossSelling_Uol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;

@Service

public class PromocaoService {
	@Autowired
	private PromocaoRepository bancoPromocao;
	
	public Optional<Promocao> encontrarPeloId(String id) {
		return bancoPromocao.findById(id);
	}
	
	public List<Promocao> encontrarTodos(){
		return bancoPromocao.findAll();
	}
	
	public Promocao inserirPromocao(Promocao novaPromocao) {
		return bancoPromocao.save(novaPromocao);
	}
	
	public void atualizarPromocao(Promocao promocaoAtualizada) {
		bancoPromocao.save(promocaoAtualizada);
	}
	
	
}