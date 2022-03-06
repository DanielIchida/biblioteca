package com.ceiba.biblioteca.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="leans")
public class LeanBooks implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String isbn;

    @Column(name="identificacion_usuario")
    private String dniUser;

    @Column(name="tipo_usuario")
    private Long typeUser;

    @Column(name="fecha_maxima_devolucion")
    private String dateMaxReturn;

    public LeanBooks(Long id, String isbn, String dniUser, Long typeUser, String dateMaxReturn) {
        this.id = id;
        this.isbn = isbn;
        this.dniUser = dniUser;
        this.typeUser = typeUser;
        this.dateMaxReturn = dateMaxReturn;
    }

    public Long getId() {
        return id;
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

    public String getDateMaxReturn() {
        return dateMaxReturn;
    }
}
