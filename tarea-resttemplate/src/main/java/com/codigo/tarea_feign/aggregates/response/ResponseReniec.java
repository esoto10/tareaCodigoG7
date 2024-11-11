package com.codigo.tarea_feign.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseReniec {

    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificador;
}
