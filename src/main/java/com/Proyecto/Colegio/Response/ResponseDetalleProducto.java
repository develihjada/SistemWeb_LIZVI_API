/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.ProductoListaDTO;
import com.Proyecto.Colegio.dto.ProductoListaDetalleDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseDetalleProducto extends ResponseGlobal {
    
    private ProductoListaDetalleDTO producto;

    public ResponseDetalleProducto(boolean exito, String mensaje, HttpStatus httpStatus, ProductoListaDetalleDTO producto) {
        super(exito, mensaje, httpStatus);
        this.producto = producto;
    }

    public ResponseDetalleProducto(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.producto = null;
    }
}
