package com.codigo.tarea_feign.repository;

import com.codigo.tarea_feign.entity.EmpresaEntity;
import com.codigo.tarea_feign.entity.PersonaNaturalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository  extends JpaRepository<EmpresaEntity, Long> {
}
