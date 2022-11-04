package com.example.springrestapi.model.dto;

import com.example.springrestapi.model.Cliente;

import java.io.Serializable;

/**
 * A DTO for the {@link Cliente} entity
 */
public record ClienteDto(String nome, String enderecoCep) implements Serializable {
}
