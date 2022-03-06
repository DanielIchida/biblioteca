package com.ceiba.biblioteca;

import com.ceiba.biblioteca.dto.RequestLensBooks;
import com.ceiba.biblioteca.services.LeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prestamo")
public class LeansControlador {

    @Autowired
    LeansService leansService;

    @PostMapping
    public ResponseEntity<?> saveLeans(@RequestBody RequestLensBooks request){

        return leansService.save(request);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getLean(@PathVariable("id") Long id){
        return leansService.getFindId(id);
    }


}

