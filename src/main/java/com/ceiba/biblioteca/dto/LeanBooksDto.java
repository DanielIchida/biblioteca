package com.ceiba.biblioteca.dto;

public class LeanBooksDto {

    private String isbn;

    private String dniUser;

    private Long typeUser;

    public LeanBooksDto(String isbn, String dniUser, Long typeUser) {
        this.isbn = isbn;
        this.dniUser = dniUser;
        this.typeUser = typeUser;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDniUser() {
        return dniUser;
    }

    public Long getTypeUser() {
        return typeUser;
    }
}
