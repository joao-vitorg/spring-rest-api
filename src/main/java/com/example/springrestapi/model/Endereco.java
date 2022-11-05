package com.example.springrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
	@Id
	private Integer cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private Integer ddd;

	public void setCep(String cep) {
		this.cep = Integer.parseInt(cep.replace("-", ""));
	}
}
