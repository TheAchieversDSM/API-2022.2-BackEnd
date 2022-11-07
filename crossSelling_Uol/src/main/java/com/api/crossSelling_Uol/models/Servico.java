package com.api.crossSelling_Uol.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Document

public class Servico {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private String categoria;
	private List <Produto> produtos = new ArrayList<>();
	private List <Servico> complementares = new ArrayList<>();
	@JsonIgnoreProperties(value = { "servico" })
	private List <Pacote> pacotes = new ArrayList<>();
	private List <Servico> servicosObrigatorios = new ArrayList<>();
}