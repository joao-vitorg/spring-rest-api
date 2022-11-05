package com.example.springrestapi.service.impl;

import com.example.springrestapi.handler.ClienteInexistenteError;
import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Endereco;
import com.example.springrestapi.model.dto.ClienteDto;
import com.example.springrestapi.repository.ClientRepository;
import com.example.springrestapi.repository.EnderecoRepository;
import com.example.springrestapi.service.ClienteService;
import com.example.springrestapi.service.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClientRepository clientRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public ClienteServiceImpl(ClientRepository clientRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clientRepository = clientRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    private Endereco findEnderecoByCep(int cep) {
        try {
            return enderecoRepository.findById(cep).orElseGet(() -> {
                Endereco novoEndereco = viaCepService.consultarCep(cep);
                return enderecoRepository.save(novoEndereco);
            });
        } catch (Exception err) {
            throw new RuntimeException("Cep errado");
        }
    }

    private Cliente saveCliente(Cliente cliente, String nome, Endereco endereco) {
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        return clientRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClienteInexistenteError::new);
    }

    @Override
    public Cliente insert(ClienteDto clienteDto) {
        Endereco endereco = findEnderecoByCep(clienteDto.enderecoCep());
        return saveCliente(new Cliente(), clienteDto.nome(), endereco);
    }

    @Override
    public Cliente update(Long id, ClienteDto clienteDto) {
        Cliente cliente = clientRepository.findById(id).orElseThrow(ClienteInexistenteError::new);
        Endereco endereco = findEnderecoByCep(clienteDto.enderecoCep());

        return saveCliente(cliente, clienteDto.nome(), endereco);
    }

    @Override
    public void delete(Long id) {
        clientRepository.findById(id).orElseThrow(ClienteInexistenteError::new);
        clientRepository.deleteById(id);
    }
}
