/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.SubFamiliaDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseListaSubFamilia extends ResponseGlobal {
    
    private List<SubFamiliaDTO> subFamilia;

    public ResponseListaSubFamilia(boolean exito, String mensaje, HttpStatus httpStatus, List<SubFamiliaDTO> subfamilia) {
        super(exito, mensaje, httpStatus);
        this.subFamilia = subfamilia;
    }

    public ResponseListaSubFamilia(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.subFamilia = Collections.emptyList();
    }
}
