/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Response;

import com.Proyecto.Colegio.dto.ClienteDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Claudio Cruzado
 */
@Data
public class ResponseListaClientes extends ResponseGlobal {
    
    private List<ClienteDTO> cliente;

    public ResponseListaClientes(boolean exito, String mensaje, HttpStatus httpStatus, List<ClienteDTO> cliente) {
        super(exito, mensaje, httpStatus);
        this.cliente = cliente;
    }

    public ResponseListaClientes(boolean exito, String mensaje, HttpStatus httpStatus) {
        super(exito, mensaje, httpStatus);
        this.cliente = Collections.emptyList();
    }
}
