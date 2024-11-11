package com.codigo.tarea_feign.service;

import com.codigo.tarea_feign.aggregates.constantes.Constants;
import com.codigo.tarea_feign.aggregates.response.ResponseReniec;
import com.codigo.tarea_feign.client.ClientReniec;
import com.codigo.tarea_feign.entity.PersonaNaturalEntity;
import com.codigo.tarea_feign.redis.RedisService;
import com.codigo.tarea_feign.repository.PersonaNaturalRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class PersonaNaturalServiceImpl implements PersonaNaturalService{
    @Autowired
    private PersonaNaturalRepository personaNaturalRepository;
    @Autowired
    private RedisService redisService;

    @Autowired
    private  ClientReniec clientReniec;

    @Value("${token.api}")
    private String token;
    @Override
    public PersonaNaturalEntity guardarPersonaNatural(String  dni) {
        PersonaNaturalEntity pn= getEntity(dni);
        if(Objects.nonNull(pn)){
            return personaNaturalRepository.save(pn);
        }else{
            return null;
        }
    }

    private PersonaNaturalEntity getEntity(String dni){
        PersonaNaturalEntity pn= new PersonaNaturalEntity();
        //ejecuto reniec
        ResponseReniec res=executionreniec(dni);
        if (Objects.nonNull(res)){
        pn.setNombres(res.getNombres());
        pn.setApellidoMaterno(res.getApellidoMaterno());
        pn.setApellidoPaterno(res.getApellidoPaterno());
        pn.setTipoDocumento(res.getTipoDocumento());
        pn.setNumeroDocumento(res.getNumeroDocumento());
        pn.setDigitoVerificador(res.getDigitoVerificador());
        pn.setUserCreated(Constants.USER);
        pn.setEstado(Constants.ESTADO_ACTIVO);
        pn.setDateCreated(new Timestamp(System.currentTimeMillis()));

        }
        return pn;
    }

    private ResponseReniec executionreniec(String dni){
        String tokenOK="Bearer "+token;
        return clientReniec.getPersonaReniec(dni,token);
    }

    @Override
    public PersonaNaturalEntity obtenerPersonaNaturalPorId(Long id) {
        return null;
    }

    @Override
    public List<PersonaNaturalEntity> obtenerTodosLasPersonaNatural() {

        return personaNaturalRepository.findAll();
    }

    @Override
    public PersonaNaturalEntity actualizarPersonaNatural(Long id, PersonaNaturalEntity personaNatural) {
        return null;
    }

    @Override
    public void eliminarPersonaNatural(Long id) {

    }
}
