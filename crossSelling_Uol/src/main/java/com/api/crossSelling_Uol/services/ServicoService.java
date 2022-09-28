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
	
	public List<Servico> encontrarServicosPeloProduto(String id){
		return bancoServico.findServicosByProd(id);
	}
	
	public Servico inserirServico(Servico novoServico) {
		return bancoServico.save(novoServico);
	}
	
	public void atualizarServico(Servico servicoAtualizado) {
		bancoServico.save(servicoAtualizado);
	}
	
	public List<Servico> encontrarExcetoComplementos(String id){
		Servico alvo = bancoServico.findById(id).orElse(null);
		List<Servico> servicos = bancoServico.findAll();
		for (int i = 0; i < alvo.getComplementares().size() ; i++) {
			Servico complemento = bancoServico.findById(alvo.getComplementares().get(i).getId()).orElse(null); 
			servicos.remove(complemento);
		}
		servicos.remove(alvo);
		return servicos;
	}
	
	public void atualizarComplementos( List<Servico> complemento, String id ) {
		Servico alvo = bancoServico.findById(id).orElse(null);
		alvo.getComplementares().addAll(complemento);
		bancoServico.save(alvo);
		
	}
	
	public List<Servico> pegarComplementos(String id){
		Servico complementar = bancoServico.findById(id).orElse(null);
		return complementar.getComplementares();
	}
	
}
