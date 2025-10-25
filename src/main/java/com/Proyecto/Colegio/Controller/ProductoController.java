/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;

import Request.RequestcrearProducto;
import Request.RequestlistarProducto;
import com.Proyecto.Colegio.Entity.Producto;
import com.Proyecto.Colegio.Response.ResponseGlobal;
import com.Proyecto.Colegio.Response.ResponseListaProducto;
import com.Proyecto.Colegio.Service.ProductoService;
import com.Proyecto.Colegio.dto.ProductoListaDTO;
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
@RequestMapping("/Productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/Mostrar")
    public ResponseEntity<ResponseListaProducto> listarProductos(@RequestBody RequestlistarProducto requ) {
        try {
            List<ProductoListaDTO> producto = (List<ProductoListaDTO>) productoService.listar(requ.getEstado(), requ.getIdfamilia(), requ.getIdsubfamilia());

            if (producto.isEmpty()) {
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
                ResponseListaProducto response = new ResponseListaProducto(false, mensaje, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String mensaje = "Productos listados con éxito.";
                @SuppressWarnings("unchecked")

                ResponseListaProducto response = new ResponseListaProducto(true, mensaje, HttpStatus.OK, producto);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. Intente más tarde.";
            ResponseListaProducto response = new ResponseListaProducto(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor.";
            ResponseListaProducto response = new ResponseListaProducto(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Insertar")
    public ResponseEntity<ResponseGlobal> crearProducto(@RequestBody RequestcrearProducto requ) {

        ResponseGlobal responseGlobal;

        try {
            productoService.guardar(requ);

            String mensaje = "Producto insertado correctamente.";
            responseGlobal = new ResponseGlobal(true, mensaje, HttpStatus.CREATED);
            return new ResponseEntity<>(responseGlobal, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. No se pudo insertar el producto.";
            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor. No se pudo insertar el producto.";
            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
