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
	
	public Optional<Promocao> findById(String id) {
		return bancoPromocao.findById(id);
	}
	
	public List<Promocao> findAll(){
		return bancoPromocao.findAll();
	}
	
	public Promocao insert(Promocao novaPromocao) {
		return bancoPromocao.save(novaPromocao);
	}
	
	public void update(Promocao promocaoAtualizada) {
		bancoPromocao.deleteById(promocaoAtualizada.getId());
		bancoPromocao.save(promocaoAtualizada);
	}
	
	
}
