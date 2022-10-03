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

import com.api.crossSelling_Uol.models.Pacote;
import com.api.crossSelling_Uol.models.Promocao;
import com.api.crossSelling_Uol.models.Servico;
import com.api.crossSelling_Uol.repositories.PacoteRepository;
import com.api.crossSelling_Uol.repositories.PromocaoRepository;
import com.api.crossSelling_Uol.services.PacoteService;
import com.api.crossSelling_Uol.services.PromocaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/promocoes")
@Api(value="Promocoes")
public class PromocaoController {
	@Autowired
	private PromocaoService servicoPromocao;
	
	@ApiOperation("Pegar promoção existente pelo ID")
	@GetMapping("/pegarPromocao/{id}")
	public Optional<Promocao> pegarPromocao(@PathVariable String id ) {
		return servicoPromocao.encontrarPeloId(id);
	}
	
	@ApiOperation("Pegar todas as promoções existentes")
	@GetMapping("/pegarTodasPromocoes")
	public List<Promocao> pegarTodasPromocoes() {
		return servicoPromocao.encontrarTodas(); 
	}
	
	/* @ApiOperation("Pegar todos as promoções pelos OFERTAS que a compoem")
	@PostMapping("/pegarTodasPromocoesPelaOferta")
	public List<Promocao> pegarTodosPacotesPeloServico(@RequestBody List<Pacote> pacotes){
		return servicoPromocao.encontrarPacotesPeloServico(pacotes);
	}  Precisamos criar OFERTA ainda */
	
	@ApiOperation("Criar nova promoção")
	@PostMapping("/criarPromocao")
	public void criarPacote(@RequestBody Promocao novaPromocao) {
		servicoPromocao.inserirPromocao(novaPromocao);
	}
	
	@ApiOperation("Atualizar promoção já existente")
	@PutMapping("/atualizarPromocao")
	public void atualizarPromocao(@RequestBody Promocao promocaoAtualizada) {
		servicoPromocao.atualizarPromocao(promocaoAtualizada);
	}
	
}
