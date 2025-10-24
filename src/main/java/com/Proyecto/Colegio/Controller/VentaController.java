/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;


import Request.RequestcrearVenta;
import com.Proyecto.Colegio.Response.ResponseGlobal;
import com.Proyecto.Colegio.Service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Claudio Cruzado
 */
@RestController
@RequestMapping("/Vender")
@CrossOrigin(origins="*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/Insertar")
    public ResponseEntity<ResponseGlobal> crearVenta(@RequestBody RequestcrearVenta requ) {
        ResponseGlobal responseGlobal;

        try {
            ventaService.guardar(requ);

            String mensaje = "Venta registrada correctamente con sus detalles.";
            responseGlobal = new ResponseGlobal(true, mensaje, HttpStatus.CREATED);
            return new ResponseEntity<>(responseGlobal, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. No se pudo registrar la venta.";
            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor. No se pudo registrar la venta.";
            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
