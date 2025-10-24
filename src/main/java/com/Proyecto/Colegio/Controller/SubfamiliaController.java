/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;


import Request.RequestlistarSubFamilia;
import com.Proyecto.Colegio.Response.ResponseListaSubFamilia;
import com.Proyecto.Colegio.Service.SubFamiliaService;
import com.Proyecto.Colegio.dto.SubFamiliaDTO;
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
@RequestMapping("/SubFamilia")
@CrossOrigin(origins="*")
public class SubfamiliaController {

    @Autowired
    private SubFamiliaService subFamiliaservice;


    @PostMapping("/Mostrar")
    public ResponseEntity<ResponseListaSubFamilia> listarSubfamilia(@RequestBody RequestlistarSubFamilia requ) {
        try {
            List<SubFamiliaDTO> apoderados = (List<SubFamiliaDTO>) subFamiliaservice.listar(requ.getEstado());

            if (apoderados.isEmpty()) {
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
                ResponseListaSubFamilia response = new ResponseListaSubFamilia(false, mensaje, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String mensaje = "Subfamilia listados con éxito.";
                @SuppressWarnings("unchecked")

                ResponseListaSubFamilia response = new ResponseListaSubFamilia(true, mensaje, HttpStatus.OK, apoderados);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. Intente más tarde.";
            ResponseListaSubFamilia response = new ResponseListaSubFamilia(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor.";
            ResponseListaSubFamilia response = new ResponseListaSubFamilia(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
