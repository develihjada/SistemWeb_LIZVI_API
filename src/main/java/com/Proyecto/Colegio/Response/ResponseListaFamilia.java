/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.FamiliaDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseListaFamilia extends ResponseGlobal {
    
    private List<FamiliaDTO> tipoDocumento;

    public ResponseListaFamilia(boolean exito, String mensaje, HttpStatus httpStatus, List<FamiliaDTO> familia) {
        super(exito, mensaje, httpStatus);
        this.tipoDocumento = familia;
    }

    public ResponseListaFamilia(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.tipoDocumento = Collections.emptyList();
    }
}
