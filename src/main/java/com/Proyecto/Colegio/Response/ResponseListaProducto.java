/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.ProductoListaDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseListaProducto extends ResponseGlobal {
    
    private List<ProductoListaDTO> productos;

    public ResponseListaProducto(boolean exito, String mensaje, HttpStatus httpStatus, List<ProductoListaDTO> producto) {
        super(exito, mensaje, httpStatus);
        this.productos = producto;
    }

    public ResponseListaProducto(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.productos = Collections.emptyList();
    }
}
