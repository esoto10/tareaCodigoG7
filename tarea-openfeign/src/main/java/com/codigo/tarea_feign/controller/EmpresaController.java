package com.codigo.tarea_feign.controller;


import com.codigo.tarea_feign.aggregates.response.ResponseSunat;
import com.codigo.tarea_feign.entity.EmpresaEntity;
import com.codigo.tarea_feign.entity.PersonaNaturalEntity;
import com.codigo.tarea_feign.exception.EmpresasException;
import com.codigo.tarea_feign.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/save")
    public ResponseEntity<EmpresaEntity> guardarempresa(@RequestParam("ruc") String ruc){
        EmpresaEntity res= empresaService.guardarEmpresa(ruc);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaEntity>> listarpn(){
        List<EmpresaEntity> lista=empresaService.obtenerTodosLasEmpresas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/sunat/{ruc}")
    public ResponseEntity<ResponseSunat> buscarXruc(@PathVariable String ruc) throws EmpresasException {
        ResponseSunat empresa= empresaService.getInfoSunat(ruc);
        return new ResponseEntity<>(empresa,HttpStatus.OK);
    }

}
