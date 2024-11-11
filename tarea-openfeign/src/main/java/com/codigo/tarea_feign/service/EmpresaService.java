package com.codigo.tarea_feign.service;

import com.codigo.tarea_feign.entity.EmpresaEntity;
import com.codigo.tarea_feign.entity.PersonaNaturalEntity;

import java.util.List;

public interface EmpresaService {
    EmpresaEntity guardarEmpresa(String ruc);
    List<EmpresaEntity> obtenerTodosLasEmpresas();

}
