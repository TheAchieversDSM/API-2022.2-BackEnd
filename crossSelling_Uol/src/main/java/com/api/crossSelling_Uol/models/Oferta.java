package com.api.crossSelling_Uol.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Oferta {
		@Id
		private String id;
		private String preco;
		private Pacote pacote;
}
