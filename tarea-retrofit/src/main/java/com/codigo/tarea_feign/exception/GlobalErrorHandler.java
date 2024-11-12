package com.codigo.tarea_feign.exception;

import com.codigo.tarea_feign.aggregates.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenerico(Exception ex, WebRequest wb){
        ErrorDTO error=new ErrorDTO(LocalDateTime.now(),"ERR-500",wb.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmpresasException.class)
    public ResponseEntity<ErrorDTO> handleDNIerror(EmpresasException ex, WebRequest wb){
        ErrorDTO error=new ErrorDTO(LocalDateTime.now(),ex.getMessage(),wb.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
