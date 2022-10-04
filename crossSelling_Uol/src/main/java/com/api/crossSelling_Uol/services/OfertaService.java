package com.api.crossSelling_Uol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crossSelling_Uol.models.Oferta;
import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.repositories.OfertaRepository;

@Service

public class OfertaService {

	@Autowired
	private OfertaRepository bancoOferta;
	
	public void  inserirOferta(Oferta novaOferta) {
		bancoOferta.save(novaOferta);
	}	
	
	public List<Oferta> encontrarTodas(){
		return bancoOferta.findAll();
	}
	
}
