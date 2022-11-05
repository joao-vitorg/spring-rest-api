package com.example.springrestapi.controller;

import com.example.springrestapi.handler.ResponseError;
import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.dto.ClienteDto;
import com.example.springrestapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@Tag(name = "Cliente", description = "Cliente API")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por id")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo cliente")
    public ResponseEntity<Cliente> insert(@RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um cliente")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody ClienteDto cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cliente")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({RuntimeException.class})
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    public ResponseEntity<ResponseError> exceptionHandler(RuntimeException err) {
        ResponseError responseError = new ResponseError(err.getMessage());
        return ResponseEntity.badRequest().body(responseError);
    }
}
