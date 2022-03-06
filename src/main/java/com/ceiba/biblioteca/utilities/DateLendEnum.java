package com.ceiba.biblioteca.utilities;

public enum DateLendEnum {
    DIEZ(10),
    OCHO(8),
    SIETE(7);

    private final int id;

    DateLendEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
