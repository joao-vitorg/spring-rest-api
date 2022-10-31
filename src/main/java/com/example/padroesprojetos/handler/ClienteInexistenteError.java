package com.example.padroesprojetos.handler;

public class ClienteInexistenteError extends RuntimeException {
    public ClienteInexistenteError() {
        super("Cliente inexistente");
    }
}
