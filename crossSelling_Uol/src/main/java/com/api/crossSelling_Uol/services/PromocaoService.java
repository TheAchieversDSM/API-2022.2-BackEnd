package com.api.crossSelling_Uol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Oferta;
import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;

@Service

public class PromocaoService {
	@Autowired
	private PromocaoRepository bancoPromocao;
	
	@Autowired
	private OfertaService ofertaService;
	
	public Optional<Promocao> encontrarPeloId(String id) {
		return bancoPromocao.findById(id);
	}
	
	public List<Promocao> encontrarTodas(){
		return bancoPromocao.findAll();
	}
	
	public List<Promocao> encontrarPromocoesPeloServico(List<Servico> servicos){
		List<Oferta> ofertas = ofertaService.encontrarOfertasPeloServico(servicos);
		System.out.print(ofertas);
		List<Promocao> promocoes = new ArrayList();
		for (int i = 0; i < ofertas.size() ; i++) {
			promocoes.addAll(bancoPromocao.findPromocoesByPack(ofertas.get(i).getId()));
			System.out.print(promocoes.get(i));
		}
		return promocoes; 
	}
	
	
	public Promocao inserirPromocao(Promocao novaPromocao) {
		return bancoPromocao.save(novaPromocao);
	}
	
	public void atualizarPromocao(Promocao promocaoAtualizada) {
		bancoPromocao.save(promocaoAtualizada);
	}
	
}
