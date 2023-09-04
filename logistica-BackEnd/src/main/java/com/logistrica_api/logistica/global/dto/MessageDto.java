package com.logistrica_api.logistica.global.dto;

import org.springframework.http.HttpStatus;

public class MessageDto {
    private HttpStatus status;
    private String mensaje;

    public MessageDto() {
    }

    public MessageDto(HttpStatus status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
