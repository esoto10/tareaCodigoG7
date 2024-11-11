package com.codigo.tarea_feign.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePost {

    private int userId;
    private int id;
    private String title;
    private String body;
}
