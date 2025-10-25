/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.FamiliaDTO;
import com.Proyecto.Colegio.dto.UnidadMedidaDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseListaUnidadMedida extends ResponseGlobal {
    
    private List<UnidadMedidaDTO> unidadmedida;

    public ResponseListaUnidadMedida(boolean exito, String mensaje, HttpStatus httpStatus, List<UnidadMedidaDTO> unidadMedia) {
        super(exito, mensaje, httpStatus);
        this.unidadmedida = unidadMedia;
    }

    public ResponseListaUnidadMedida(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.unidadmedida = Collections.emptyList();
    }
}
