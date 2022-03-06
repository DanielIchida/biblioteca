package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.entities.TypeUser;

import java.util.Optional;

public interface ITypeService {
    public Optional<TypeUser> getFindId(Long id);
}
