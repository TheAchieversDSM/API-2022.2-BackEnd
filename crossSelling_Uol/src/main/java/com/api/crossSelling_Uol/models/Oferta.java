package com.api.crossSelling_Uol.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Oferta {
		@Id
		private String id;
		private Pacote pacote;
		private Object preco;
}
