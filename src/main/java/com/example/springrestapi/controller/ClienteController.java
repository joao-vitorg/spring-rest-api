package com.example.springrestapi.controller;

import com.example.springrestapi.handler.ResponseError;
import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.dto.ClienteDto;
import com.example.springrestapi.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> index() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByID(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateByID(@PathVariable Long id, @RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseError> exceptionHandler(RuntimeException err) {
        ResponseError responseError = new ResponseError(err.getMessage());
        return ResponseEntity.badRequest().body(responseError);
    }
}
