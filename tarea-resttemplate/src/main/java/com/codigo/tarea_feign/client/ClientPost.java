package com.codigo.tarea_feign.client;

import com.codigo.tarea_feign.aggregates.response.ResponsePost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post" , url = "https://jsonplaceholder.typicode.com/posts")
public interface ClientPost {

    @GetMapping
  List<ResponsePost> listarPosts();

}
