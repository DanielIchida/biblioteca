package com.ceiba.biblioteca.repository;

import com.ceiba.biblioteca.entities.LeanBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface LeansDao extends CrudRepository<LeanBooks,Long> {
    Optional<LeanBooks> findPrestamosByIdentificacionUsuario(@Param("iduser") String idUser);
}
