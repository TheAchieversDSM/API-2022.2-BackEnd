package com.api.crossSelling_Uol.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
public class Pacote {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private Servico servico;
	private String periodo;
	private List<Produto> produtos = new ArrayList<>();
	
}
