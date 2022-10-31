package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.cliente.Cliente;
import com.example.padroesprojetos.model.cliente.ClienteDto;

public interface ClienteService {
	Iterable<Cliente> findAll();

	Cliente findById(Long id);

	Cliente insert(ClienteDto clienteDto);

	Cliente update(Long id, ClienteDto clienteDto);

	void delete(Long id);
}
