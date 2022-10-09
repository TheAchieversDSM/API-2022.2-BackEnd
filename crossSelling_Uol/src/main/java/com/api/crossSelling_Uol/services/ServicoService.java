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
		Servico servico = bancoServico.findById(servicoAtualizado.getId()).orElse(null);
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
	
	public List<Servico> pegarServicosPelaCategoria (String categoria) {
	 return	bancoServico.findServicosByCate(categoria);
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
	
	public List<Servico> pegarComplementosParaCarrinho(List<Servico> servicos){
		List<Servico> complementos = new ArrayList();
		for (int i = 0; i < servicos.size() ; i++) {
			Servico servico = servicos.get(i);
			if(servico.getComplementares().size() != 0   ) {
				complementos.add(servico.getComplementares().get(0));
			}
		}
		return complementos;
	}
	
}
