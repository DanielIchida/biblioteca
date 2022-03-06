package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.entities.TypeUser;
import com.ceiba.biblioteca.repository.TypeUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeUserService implements ITypeService{

    @Autowired
    TypeUserDao typeUserDao;

    @Override
    public Optional<TypeUser> getFindId(Long id) {
        return typeUserDao.findById(id);
    }
}
