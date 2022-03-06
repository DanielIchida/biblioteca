package com.ceiba.biblioteca.dto;

public class ResultadoPrestar {

    private Long id;
    private String dateMaxReturn;

    public ResultadoPrestar(Long id, String dateMaxReturn) {
        this.id = id;
        this.dateMaxReturn = dateMaxReturn;
    }

    public Long getId() {
        return id;
    }

    public String getDateMaxReturn() {
        return dateMaxReturn;
    }
}
