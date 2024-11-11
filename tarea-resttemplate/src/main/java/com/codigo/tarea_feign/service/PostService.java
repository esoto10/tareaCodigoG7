package com.codigo.tarea_feign.service;

import com.codigo.tarea_feign.entity.PostEntity;

import java.util.List;

public interface PostService {

    List<PostEntity> obtenerTodoslosPosts();

}
