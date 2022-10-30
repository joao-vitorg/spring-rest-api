package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.cliente.Cliente;

import java.util.Optional;

public interface ClienteInterface {
	Iterable<Cliente> buscarTodos();

	Optional<Cliente> buscarPorId(Long id);

	void inserir(Cliente cliente);

	boolean atualizar(Long id, Cliente cliente);

	boolean deletar(Long id);
}
