package com.ceiba.biblioteca.dto.mappers;
import com.ceiba.biblioteca.dto.LeanBooksDto;
import com.ceiba.biblioteca.entities.LeanBooks;

public class LendBookMappers {

    private final String dateMaxReturn;

    public LendBookMappers(String dateMaxReturn) {
        this.dateMaxReturn = dateMaxReturn;
    }

    public LeanBooks mapper(LeanBooksDto dto) {
        return new LeanBooks(
                0L,
                dto.getIsbn(),
                dto.getDniUser(),
                dto.getTypeUser(),
                this.dateMaxReturn
        );
    }

    public String getDateMaxReturn() {
        return dateMaxReturn;
    }
}
