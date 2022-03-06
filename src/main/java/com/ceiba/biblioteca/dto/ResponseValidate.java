package com.ceiba.biblioteca.dto;

public class ResponseValidate {

    public String mensaje;

    public ResponseValidate(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
