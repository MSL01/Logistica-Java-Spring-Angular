package com.logistrica_api.logistica.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends Exception {
    public NotFound(String mensaje) {
        super(mensaje);
    }
}
