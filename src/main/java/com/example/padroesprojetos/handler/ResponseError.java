package com.example.padroesprojetos.handler;

import java.util.Date;

public record ResponseError(Date timestamp, String error) {
    public ResponseError(String error) {
        this(new Date(), error);
    }
}
