/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;

import Request.RequestlistarMarca;
import com.Proyecto.Colegio.Entity.Marca;
import com.Proyecto.Colegio.Response.ResponseListaMarca;
import com.Proyecto.Colegio.Service.MarcaService;
import com.Proyecto.Colegio.dto.MarcaDTO;
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
@RequestMapping("/Marca")
@CrossOrigin(origins="*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping("/Mostrar")
    public ResponseEntity<ResponseListaMarca> listarDocumentos(@RequestBody RequestlistarMarca requ) {
        try {
            List<Marca> marca = (List<Marca>) marcaService.listar(requ.getEstado());
            List<?> dataList = marca;

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
                ResponseListaMarca response = new ResponseListaMarca(false, mensaje, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String mensaje = "Unidad de Medida listada con éxito.";
                @SuppressWarnings("unchecked")
                List<MarcaDTO> marcaDTO = (List<MarcaDTO>) dataList;

                ResponseListaMarca response = new ResponseListaMarca(true, mensaje, HttpStatus.OK, marcaDTO);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. Intente más tarde.";
            ResponseListaMarca response = new ResponseListaMarca(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor.";
            ResponseListaMarca response = new ResponseListaMarca(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
