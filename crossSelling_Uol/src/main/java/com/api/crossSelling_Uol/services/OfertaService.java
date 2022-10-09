package com.api.crossSelling_Uol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Oferta;
import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.OfertaRepository;

@Service

public class OfertaService {

	@Autowired
	private OfertaRepository bancoOferta;
	
	@Autowired
	private PacoteService pacoteService;
	
	public void inserirOferta(Oferta novaOferta) {
		bancoOferta.save(novaOferta);
	}	
	
	public List<Oferta> encontrarTodas(){
		return bancoOferta.findAll();
	}
	
	public List<Oferta> encontrarOfertasPeloServico(List<Servico> servicos){
		List<Pacote> pacotes = pacoteService.encontrarPacotesPeloServico(servicos);
		List<Oferta> ofertas =  new ArrayList();
		for (int i = 0; i < pacotes.size() ; i++) {
			ofertas.addAll(bancoOferta.findOfertaByPack(pacotes.get(i).getId()));
		}
		return ofertas;
	}
	
	
	public Optional<Oferta> encontrarPeloId(String id) {
		return bancoOferta.findById(id);
	}
	
	public void atualizarOferta(Oferta ofertaAtualizada) {
		bancoOferta.save(ofertaAtualizada);
	}

	
}
