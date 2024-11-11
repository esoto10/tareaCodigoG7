package com.codigo.tarea_feign.aggregates.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
    @JsonFormat(pattern = "dd-MM-YYYY hh:mm:ss")
    private LocalDateTime localDateTime;
    private String message;
    private String details;

}
