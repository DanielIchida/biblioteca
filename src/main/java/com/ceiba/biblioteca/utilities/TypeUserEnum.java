package com.ceiba.biblioteca.utilities;

public enum TypeUserEnum {
    AFILIADO(1),
    EMPLEADO(2),
    INVITADO(3),
    DESCONOCIDO(4);

    private final int id;
    TypeUserEnum(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
