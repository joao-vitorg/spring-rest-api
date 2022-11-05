package com.example.springrestapi.handler;

import java.io.Serializable;
public record ResponseError(String error) implements Serializable {
}
