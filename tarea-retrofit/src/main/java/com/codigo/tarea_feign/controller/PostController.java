package com.codigo.tarea_feign.controller;

import com.codigo.tarea_feign.entity.PostEntity;
import com.codigo.tarea_feign.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<PostEntity> listarpost(){
        return postService.obtenerTodoslosPosts();
    }
}
