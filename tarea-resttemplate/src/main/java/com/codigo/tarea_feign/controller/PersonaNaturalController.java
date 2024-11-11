package com.codigo.tarea_feign.controller;

import com.codigo.tarea_feign.entity.PersonaNaturalEntity;
import com.codigo.tarea_feign.service.PersonaNaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/personaNatural")
public class PersonaNaturalController {

    @Autowired
    private PersonaNaturalService personaNaturalService;

    @PostMapping
    public ResponseEntity<PersonaNaturalEntity> guardarPersona(@RequestParam("dni") String dni){
        PersonaNaturalEntity pn= personaNaturalService.guardarPersonaNatural(dni);
        return new ResponseEntity<>(pn, HttpStatus.CREATED);

    }

    @GetMapping
    public List<PersonaNaturalEntity> listarpn(){
        return personaNaturalService.obtenerTodosLasPersonaNatural();
    }


}
