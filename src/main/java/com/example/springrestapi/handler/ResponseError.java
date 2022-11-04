package com.example.springrestapi.handler;

import java.io.Serializable;
import java.util.Date;

public record ResponseError(Date timestamp, String error) implements Serializable {
    public ResponseError(String error) {
        this(new Date(), error);
    }
}
