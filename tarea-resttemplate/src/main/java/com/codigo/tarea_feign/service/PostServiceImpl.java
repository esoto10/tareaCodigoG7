package com.codigo.tarea_feign.service;


import com.codigo.tarea_feign.aggregates.response.ResponsePost;
import com.codigo.tarea_feign.client.ClientPost;
import com.codigo.tarea_feign.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private ClientPost clientPost;

    @Override
    public List<PostEntity> obtenerTodoslosPosts() {

        List<ResponsePost> lista=executePost();

        return lista.stream().map(obj->{
            PostEntity post = new PostEntity();
            post.setUserId(obj.getUserId());
            post.setId(obj.getId());
            post.setBody(obj.getBody());
            post.setTitle(obj.getTitle());
            return post;
        }).collect(Collectors.toList());
    }

    private  List<ResponsePost> executePost(){
        return clientPost.listarPosts();
    }
}
