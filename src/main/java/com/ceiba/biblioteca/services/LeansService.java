package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.dto.LeanBooksDto;
import com.ceiba.biblioteca.dto.ResultadoPrestar;
import com.ceiba.biblioteca.dto.RequestLensBooks;
import com.ceiba.biblioteca.dto.mappers.LendBookMappers;
import com.ceiba.biblioteca.entities.LeanBooks;
import com.ceiba.biblioteca.repository.LeansDao;
import com.ceiba.biblioteca.utilities.DateLendEnum;
import com.ceiba.biblioteca.utilities.DateUtil;
import com.ceiba.biblioteca.utilities.TypeUserEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class LeansService implements ILeans {

    @Autowired
    private LeansDao leansDao;

    @Autowired
    private ValidateService validateService;

    @Override
    public ResponseEntity<?> save(RequestLensBooks prestamo)
    {
         validateService.validate(prestamo);
         try{
             LeanBooksDto newLendDto = new LeanBooksDto(
                     prestamo.getIsbn(),
                     prestamo.getIdentificacionUsuario(),
                     prestamo.getTipoUsuario()
             );
             int dias = 0;
             if(prestamo.getTipoUsuario() == TypeUserEnum.AFILIADO.getId()) dias = DateLendEnum.DIEZ.getId();
             if(prestamo.getTipoUsuario() == TypeUserEnum.EMPLEADO.getId()) dias = DateLendEnum.OCHO.getId();
             if(prestamo.getTipoUsuario() == TypeUserEnum.INVITADO.getId()) dias = DateLendEnum.SIETE.getId();
             LocalDate fechaPrestamo = LocalDate.now();
             LocalDate fechaEntrega = DateUtil.sumarFecha(fechaPrestamo,dias);
             String maxFecha = DateUtil.formatFecha(fechaEntrega);
             LendBookMappers lends = new LendBookMappers(maxFecha);
             LeanBooks newL = leansDao.save(lends.mapper(newLendDto));
             ResultadoPrestar result = new ResultadoPrestar(newL.getId(),newL.getDateMaxReturn());
             return ResponseEntity.ok(result);
         }catch (Exception e){
             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @Override
    public ResponseEntity<?> getFindId(Long id) {
        try {
            return ResponseEntity.ok(leansDao.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getFindByDni(String ident) {
        try {
            return ResponseEntity.ok(leansDao.findPrestamosByIdentificacionUsuario(ident));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
