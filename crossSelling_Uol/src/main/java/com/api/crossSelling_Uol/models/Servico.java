package com.api.crossSelling_Uol.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Servico {
	@Id
	private String id;
	private String nome;
	private String preco;
	private String descricao;
	private List<Produto> produtos;

}
