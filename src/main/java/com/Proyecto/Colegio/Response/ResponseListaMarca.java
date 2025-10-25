/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.FamiliaDTO;
import com.Proyecto.Colegio.dto.MarcaDTO;
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
public class ResponseListaMarca extends ResponseGlobal {
    
    private List<MarcaDTO> marca;

    public ResponseListaMarca(boolean exito, String mensaje, HttpStatus httpStatus, List<MarcaDTO> marca) {
        super(exito, mensaje, httpStatus);
        this.marca = marca;
    }

    public ResponseListaMarca(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.marca = Collections.emptyList();
    }
}
