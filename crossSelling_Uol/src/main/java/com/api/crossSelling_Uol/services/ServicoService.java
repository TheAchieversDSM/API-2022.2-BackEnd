package com.api.crossSelling_Uol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.crossSelling_Uol.models.Produto;
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
	
	public List<Servico> encontrarServicosPeloProduto(String id){
		return bancoServico.findServicosByProd(id);
		
	}
	
	public Servico inserirServico(Servico novoServico) {
		return bancoServico.save(novoServico);
	}
	
	public void atualizarServico(Servico servicoAtualizado) {
		bancoServico.save(servicoAtualizado);
	}
	
	public List<Servico> pegarServicoObrigatorio (String id) {
		Servico obrigatorio = bancoServico.findById(id).orElse(null);
		return obrigatorio.getServicosObrigatorios();
	}
	
	public void inserirServicoObrigatorio (Servico novoServicoObrigatorio, String id) {
		Servico alvo = bancoServico.findById(id).orElse(null);
		alvo.getServicosObrigatorios().add(novoServicoObrigatorio);
		bancoServico.save(alvo);
	}

}
