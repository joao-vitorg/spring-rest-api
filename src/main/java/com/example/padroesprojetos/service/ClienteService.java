package com.example.padroesprojetos.service;

import com.example.padroesprojetos.model.cliente.ClientRepository;
import com.example.padroesprojetos.model.cliente.Cliente;
import com.example.padroesprojetos.model.endereco.Endereco;
import com.example.padroesprojetos.model.endereco.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements ClienteInterface {
    private final ClientRepository clientRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public ClienteService(ClientRepository clientRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clientRepository = clientRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);

            return novoEndereco;
        });

        cliente.setEndereco(endereco);

        clientRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public boolean atualizar(Long id, Cliente cliente) {
        if (clientRepository.findById(id).isEmpty()) return false;

        salvarClienteComCep(cliente);
        return true;
    }

    @Override
    public boolean deletar(Long id) {
        if (!clientRepository.existsById(id)) return false;

        clientRepository.deleteById(id);
        return true;
    }
}
