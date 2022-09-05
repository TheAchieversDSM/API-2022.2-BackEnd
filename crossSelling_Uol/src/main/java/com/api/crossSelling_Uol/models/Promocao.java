package com.api.crossSelling_Uol.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Promocao {
	
	@Id
	private String id;
	private String nome;
	//private List<Pacote> pacotes;
	
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
	
	//public List<Produto> getPacotes() {
		//return complementares;
	//}
	//public void setComplementares(List<Produto> complementares) {
	//	this.complementares = complementares;
	//}
	
	
}
