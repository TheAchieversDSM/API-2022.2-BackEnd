package com.api.crossSelling_Uol.models;

//import java.util.List;

import org.springframework.data.annotation.Id;

public class Pacote {
	@Id
	private String id;
	private String nome;
	private String descricao;
	//private List<Servicos> servicos;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
