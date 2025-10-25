/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;

import Request.RequestlistarUnidadMedida;
import com.Proyecto.Colegio.Entity.UnidadMedida;
import com.Proyecto.Colegio.Response.ResponseListaUnidadMedida;
import com.Proyecto.Colegio.Service.UnidadMedidaService;
import com.Proyecto.Colegio.dto.UnidadMedidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Claudio Cruzado
 */
@RestController
@RequestMapping("/UnidadMedida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadmedidaService;

    @PostMapping("/Mostrar")
    public ResponseEntity<ResponseListaUnidadMedida> listarDocumentos(@RequestBody RequestlistarUnidadMedida requ) {
        try {
            List<UnidadMedida> unidadmedida = (List<UnidadMedida>) unidadmedidaService.listar(requ.getEstado());
            List<?> dataList = unidadmedida;

            if (dataList.isEmpty()) {
                String mensaje;
                switch (requ.getEstado()) {
                    case 1:
                        mensaje = "No se encontró ningún elemento activo.";
                        break;
                    case 0:
                        mensaje = "No se encontró ningún elemento inactivo.";
                        break;
                    case 2:
                    default:
                        mensaje = "No se encontró ningún elemento.";
                        break;
                }
                ResponseListaUnidadMedida response = new ResponseListaUnidadMedida(false, mensaje, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String mensaje = "Unidad de Medida listada con éxito.";
                @SuppressWarnings("unchecked")
                List<UnidadMedidaDTO> unidadmedidaDTO = (List<UnidadMedidaDTO>) dataList;

                ResponseListaUnidadMedida response = new ResponseListaUnidadMedida(true, mensaje, HttpStatus.OK, unidadmedidaDTO);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. Intente más tarde.";
            ResponseListaUnidadMedida response = new ResponseListaUnidadMedida(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor.";
            ResponseListaUnidadMedida response = new ResponseListaUnidadMedida(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
