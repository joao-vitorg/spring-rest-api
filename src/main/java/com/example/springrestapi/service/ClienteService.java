package com.example.springrestapi.service;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.dto.ClienteDto;

public interface ClienteService {
	Iterable<Cliente> findAll();

	Cliente findById(Long id);

	Cliente insert(ClienteDto clienteDto);

	Cliente update(Long id, ClienteDto clienteDto);

	void delete(Long id);
}
