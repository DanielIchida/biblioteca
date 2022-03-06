package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.dto.ResponseValidate;
import com.ceiba.biblioteca.dto.RequestLensBooks;
import com.ceiba.biblioteca.entities.PrestamoLibros;
import com.ceiba.biblioteca.entities.TypeUser;
import com.ceiba.biblioteca.repository.LeansDao;
import com.ceiba.biblioteca.utilities.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateService {

    @Autowired
    LeansDao prestamoDao;

    @Autowired
    TypeUserService typeUserService;

    public ResponseEntity<?> validate(RequestLensBooks request){
        String val = "";
        if(!Validation.validateIdUser(request.getIdentificacionUsuario())){
            val = "El usuario con identificación"+request.getIdentificacionUsuario()+" no esta permitido";
        }else if(!Validation.validateIsbn(request.getIsbn())){
            val = "El libro con Isbn "+request.getIsbn()+" no esta permitido";
        }
        Optional<TypeUser> type = typeUserService.getFindId(request.getTipoUsuario());
        if(!type.isPresent()){
            val = "Tipo de usuario no permitido en la biblioteca";
        }
        if(request.getTipoUsuario() == 3){
            Optional<PrestamoLibros> prestamos = prestamoDao.findPrestamosByIdentificacionUsuario(
                    request.getIdentificacionUsuario()
            );
            if(prestamos.isPresent()){
                val = "El usuario con identificación "+request.getIdentificacionUsuario()+" ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
            }
        }
        return new ResponseEntity<>(validateMessage(val), HttpStatus.BAD_REQUEST);
    }

    public String validateMessage(String msg){
        return new ResponseValidate(msg).getMensaje();
    }

}
