package com.codigo.tarea_feign.service;

import com.codigo.tarea_feign.entity.PersonaNaturalEntity;

import java.util.List;

public interface PersonaNaturalService {

    PersonaNaturalEntity guardarPersonaNatural(String  dni);
    PersonaNaturalEntity obtenerPersonaNaturalPorId(Long id);
    List<PersonaNaturalEntity> obtenerTodosLasPersonaNatural();
    PersonaNaturalEntity actualizarPersonaNatural(Long id, PersonaNaturalEntity personaNatural);
    void eliminarPersonaNatural(Long id);
}
