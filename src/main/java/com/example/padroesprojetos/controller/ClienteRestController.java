package com.example.padroesprojetos.controller;

import com.example.padroesprojetos.model.cliente.Cliente;
import com.example.padroesprojetos.service.ClienteInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {
    private final ClienteInterface clienteInterface;

    public ClienteRestController(ClienteInterface clienteInterface) {
        this.clienteInterface = clienteInterface;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> index() {
        return ResponseEntity.ok(clienteInterface.buscarTodos());
    }

    /**
     * d
     *
     * @param cliente b
     * @return c
     * @apiNote a
     */
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        clienteInterface.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByID(@PathVariable Long id) {
        return ResponseEntity.of(clienteInterface.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByID(@PathVariable Long id, @RequestBody Cliente cliente) {
        return (clienteInterface.atualizar(id, cliente) ? ResponseEntity.ok() : ResponseEntity.badRequest()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        return (clienteInterface.deletar(id) ? ResponseEntity.ok() : ResponseEntity.badRequest()).build();
    }
}
