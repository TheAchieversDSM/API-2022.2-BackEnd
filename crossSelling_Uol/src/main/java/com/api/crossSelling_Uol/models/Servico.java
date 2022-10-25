package com.api.crossSelling_Uol.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class Servico {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private List<String> categoria;
	private List<Pacote> pacotes;
	private List <Produto> produtos = new ArrayList<>();
	private List <Servico> servicosObrigatorios = new ArrayList<>();
	private List<Servico> complementares = new ArrayList<>();

}
