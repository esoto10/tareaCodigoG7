package com.codigo.tarea_feign.client;

import com.codigo.tarea_feign.aggregates.response.ResponseReniec;
import com.codigo.tarea_feign.aggregates.response.ResponseSunat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-sunat", url = "https://api.apis.net.pe/v2/sunat")
public interface ClientSunat {

    @GetMapping("/ruc/full")
    ResponseSunat getEmpresaRUC(@RequestParam("numero") String ruc,
                                @RequestHeader("Authorization") String token);

}
