package com.api.crossSelling_Uol.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public class Promocao {
	
	@Id
	private String id;
	private String nome;
	private String preco;
	private List<Pacote> pacotes = new ArrayList<>();
		
}
