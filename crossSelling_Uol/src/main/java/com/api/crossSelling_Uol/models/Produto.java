package com.api.crossSelling_Uol.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Produto {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private String categoria;
	private String quantidade;
}