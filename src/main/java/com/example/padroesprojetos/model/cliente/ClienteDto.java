package com.example.padroesprojetos.model.cliente;

import java.io.Serializable;

/**
 * A DTO for the {@link Cliente} entity
 */
public record ClienteDto(String nome, String enderecoCep) implements Serializable {
}
