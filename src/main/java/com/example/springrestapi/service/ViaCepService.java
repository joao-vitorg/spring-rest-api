package com.example.springrestapi.service;

import com.example.springrestapi.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") int cep);
}
