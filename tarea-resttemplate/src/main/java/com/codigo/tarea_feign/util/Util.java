package com.codigo.tarea_feign.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class Util {

    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();

    public static <T> String convertirasString(T t){
        try{
            Objects.requireNonNull(t);
            return OBJECT_MAPPER.writeValueAsString(t);
        }catch(JsonProcessingException e){
            throw new RuntimeException("Error al convertir en una string");
        }
    }

    public static <T> T convertirdesdString(String json, Class<T> tipoclase){
        try{
            Objects.requireNonNull(json);
            return OBJECT_MAPPER.readValue(json,tipoclase);
        }catch(JsonProcessingException e){
            throw new RuntimeException("Error al convertir en una string");
        }
    }

}
