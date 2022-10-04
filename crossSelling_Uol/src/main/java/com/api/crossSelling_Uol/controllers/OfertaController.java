package com.api.crossSelling_Uol.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crossSelling_Uol.models.Oferta;
import com.api.crossSelling_Uol.models.Produto;
import com.api.crossSelling_Uol.services.OfertaService;
import com.api.crossSelling_Uol.services.PacoteService;
import com.api.crossSelling_Uol.services.PromocaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/ofertas")
@Api(value="Ofertas")


public class OfertaController {

	@Autowired
	private OfertaService servicoOferta;
	
	@ApiOperation("Pegar todas as ofertas existentes")
	@GetMapping("/pegarTodasOfertas")
	
	public List<Oferta> encontrarTodas(){
		return servicoOferta.encontrarTodas();
	}
	
	@ApiOperation("Pegar oferta existente pelo ID")
	@GetMapping("/pegarOferta/{id}")
	public Optional<Oferta> pegarOferta(@PathVariable String id ) {
		return servicoOferta.encontrarPeloId(id);
	}
	

	@ApiOperation("Criar nova oferta")
	@PostMapping("/criarOferta")
	public void inserirOferta(@RequestBody Oferta novaOferta) {
		servicoOferta.inserirOferta(novaOferta);
	}
	
	@ApiOperation("Atualizar oferta já existente")
	@PutMapping("/atualizarOferta")
	public void atualizarOferta(@RequestBody Oferta ofertaAtualizado) {
		servicoOferta.atualizarOferta(ofertaAtualizado);
	}
	
	
	
	
	
}
