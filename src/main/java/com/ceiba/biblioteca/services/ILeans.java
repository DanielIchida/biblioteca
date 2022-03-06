package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.dto.RequestLensBooks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ILeans {
    ResponseEntity<?> save(RequestLensBooks prestamo);
    ResponseEntity<?> getFindId(Long id);
    ResponseEntity<?> getFindByDni(String ident);
}
