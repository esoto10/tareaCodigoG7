package com.codigo.tarea_feign.service;

import com.codigo.tarea_feign.aggregates.constantes.Constants;
import com.codigo.tarea_feign.aggregates.response.ResponseSunat;
import com.codigo.tarea_feign.client.ClientSunat;
import com.codigo.tarea_feign.entity.EmpresaEntity;
import com.codigo.tarea_feign.entity.PersonaNaturalEntity;
import com.codigo.tarea_feign.exception.EmpresasException;
import com.codigo.tarea_feign.redis.RedisService;
import com.codigo.tarea_feign.repository.EmpresaRepository;
import com.codigo.tarea_feign.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class EmpresaServiceImpl  implements  EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ClientSunat clientSunat;

    @Value("${token.api}")
    private  String token;

    @Override
    public EmpresaEntity guardarEmpresa(String ruc) {
        ResponseSunat resultado= executeFeigncreate(token,ruc);
        // si retorna nulo entonces lanzar la excepcion
        EmpresaEntity empresaEntity= getEntityEmpresa(resultado);
        return empresaRepository.save(empresaEntity);
    }

    private EmpresaEntity getEntityEmpresa(ResponseSunat o){

        Objects.requireNonNull(o,"La empresa es nula");
        EmpresaEntity emp= new EmpresaEntity();
        emp.setRazonSocial(o.getRazonSocial());
        emp.setTipoDocumento(o.getTipoDocumento());
        emp.setNumeroDocumento(o.getNumeroDocumento());
        emp.setEstado(o.getEstado());
        emp.setCondicion(o.getCondicion());
        emp.setDireccion(o.getDireccion());
        emp.setUbigeo(o.getUbigeo());
        emp.setViaTipo(o.getViaTipo());
        emp.setZonaCodigo(o.getZonaCodigo());
        emp.setZonaTipo(o.getZonaTipo());
        emp.setNumero(o.getNumero());
        emp.setInterior(o.getInterior());
        emp.setLote(o.getLote());
        emp.setManzana(o.getManzana());
        emp.setKilometro(o.getKilometro());
        emp.setDistrito(o.getDistrito());
        emp.setProvincia(o.getProvincia());
        emp.setDepartamento(o.getDepartamento());
        emp.setEsAgenteRetencion(o.isEsAgenteRetencion());
        emp.setTipo(o.getTipo());
        emp.setActividadEconomica(o.getActividadEconomica());
        emp.setNumeroTrabajadores(o.getNumeroTrabajadores());
        emp.setTipoFacturacion(o.getTipoFacturacion());
        emp.setTipoContabilidad(o.getTipoContabilidad());
        emp.setComercioExterior(o.getComercioExterior());
        emp.setUserCreated("admin");
        emp.setDateCreated(new Timestamp(System.currentTimeMillis()));
        return emp;

    }

    private ResponseSunat executeFeigncreate(String token, String ruc){
        String tokenOK="Bearer "+token;
       return  clientSunat.getEmpresaRUC(ruc,tokenOK);
    }

    @Override
    public List<EmpresaEntity> obtenerTodosLasEmpresas() {
        return  empresaRepository.findAll();
    }


    @Override
    public ResponseSunat getInfoSunat(String ruc) {
        ResponseSunat datosSunat= new ResponseSunat();
        //busca ruc en redis
        String redisonfo=redisService.getInRedis(ruc);
        if(Objects.nonNull(redisonfo)){
            return datosSunat= Util.convertirdesdString(redisonfo,ResponseSunat.class);
        }else{
            // se ejecuta el  metodo externo
            String tokenOK="Bearer "+token;
            datosSunat= clientSunat.getEmpresaRUC(ruc,tokenOK);
            if(Objects.nonNull(datosSunat)){
                //insertar objeto en redis
                String dataforRedis=Util.convertirasString(datosSunat);
                redisService.saveInRedis(Constants.REDIS_KEY_API_SUNAT+ruc,dataforRedis,5);
                return datosSunat;
            }else{
                throw new EmpresasException("empresa no existe en sunat");
            }
        }
    }
}
