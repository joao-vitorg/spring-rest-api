package com.example.springrestapi.handler;

public class ClienteInexistenteError extends RuntimeException {
    public ClienteInexistenteError() {
        super("Cliente não encontrado");
    }
}
