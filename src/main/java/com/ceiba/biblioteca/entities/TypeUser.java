package com.ceiba.biblioteca.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="typeuser")
public class TypeUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    public TypeUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
