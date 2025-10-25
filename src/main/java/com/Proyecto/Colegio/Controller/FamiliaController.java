/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;

import Request.RequestlistarFamilia;
import com.Proyecto.Colegio.Entity.Familia;
import com.Proyecto.Colegio.Response.ResponseListaFamilia;
import com.Proyecto.Colegio.Service.FamiliaService;
import com.Proyecto.Colegio.dto.FamiliaDTO;
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
@CrossOrigin(origins="*")
@RequestMapping("/Familia")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/Mostrar")
    public ResponseEntity<ResponseListaFamilia> listarDocumentos(@RequestBody RequestlistarFamilia requ) {
        try {
            List<Familia> familia = (List<Familia>) familiaService.listar(requ.getEstado());
            List<?> dataList = familia;

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
                ResponseListaFamilia response = new ResponseListaFamilia(false, mensaje, HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String mensaje = "Familia listada con éxito.";
                @SuppressWarnings("unchecked")
                List<FamiliaDTO> familiaDTO = (List<FamiliaDTO>) dataList;

                ResponseListaFamilia response = new ResponseListaFamilia(true, mensaje, HttpStatus.OK, familiaDTO);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            String mensaje = "Error al acceder a la base de datos. Intente más tarde.";
            ResponseListaFamilia response = new ResponseListaFamilia(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            String mensaje = "Error interno inesperado del servidor.";
            ResponseListaFamilia response = new ResponseListaFamilia(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/Insertar")
//    public ResponseEntity<ResponseGlobal> crearDocumento(@RequestBody RequestcrearDocumento requ) {
//
//        ResponseGlobal responseGlobal;
//
//        try {
//            List<TipoDocumento> documentos = (List<TipoDocumento>) tipoDocumentoService.existe(requ.getDescripcion());
//            if (documentos.isEmpty()) {
//                tipoDocumentoService.guardar(requ);
//                String mensaje = "Tipo de Documento insertado correctamente.";
//                responseGlobal = new ResponseGlobal(true, mensaje, HttpStatus.CREATED);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.CREATED);
//            } else {
//                String mensaje = "Tipo de Documento ya existe";
//                responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.CONFLICT);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.CONFLICT);
//            }
//
//        } catch (DataAccessException e) {
//            String mensaje = "Error al acceder a la base de datos. No se pudo insertar Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        } catch (Exception e) {
//            String mensaje = "Error interno inesperado del servidor. No se pudo insertar Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/Actualizar")
//    public ResponseEntity<ResponseGlobal> actualizarDocumento(
//            @RequestBody RequestactualizarDocumento requ
//    ) {
//        ResponseGlobal responseGlobal;
//
//        try {
//
//            List<TipoDocumento> documentos = (List<TipoDocumento>) tipoDocumentoService.existe(requ.getDescripcion());
//            if (documentos.isEmpty()) {
//                tipoDocumentoService.actualizar(requ);
//                String mensaje = "Tipo de Documento actualizado correctamente.";
//                responseGlobal = new ResponseGlobal(true, mensaje, HttpStatus.OK);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.OK);
//            } else {
//                String mensaje = "Tipo de Documento ya existe";
//                responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.CONFLICT);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.CONFLICT);
//            }
//
//        } catch (DataAccessException e) {
//            String mensaje = "Error al acceder a la base de datos. No se pudo actualizar el Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        } catch (Exception e) {
//            String mensaje = "Error interno inesperado del servidor. No se pudo actualizar el Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/ActualizarEstado")
//    public ResponseEntity<ResponseGlobal> actualizarEstadoDocumento( 
//            @RequestBody  RequestactualizarEstadoDocumento requ
//    ) {
//        ResponseGlobal responseGlobal;
//
//        try {
//            List<TipoDocumento> documentos = (List<TipoDocumento>) tipoDocumentoService.existeId(requ.getId());
//
//            if (!documentos.isEmpty()) {
//                tipoDocumentoService.actualizarEstado(requ.getId(), requ.getEstado());
//                String estadoTexto;
//                switch (requ.getEstado()) {
//                    case 1:
//                        estadoTexto = "activo";
//                        break;
//                    case 0:
//                        estadoTexto = "inactivo";
//                        break;
//                    default:
//                        estadoTexto = String.valueOf(requ.getEstado());
//                }
//                String mensaje = "Estado del Tipo de Documento ID " + requ.getId() + " actualizado a " + estadoTexto + " correctamente.";
//                responseGlobal = new ResponseGlobal(true, mensaje, HttpStatus.OK);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.OK);
//            } else {
//                String mensaje = "Id " + requ.getId() + " Tipo de Documento no existe";
//                responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.NOT_FOUND);
//                return new ResponseEntity<>(responseGlobal, HttpStatus.NOT_FOUND);
//            }
//
//        } catch (DataAccessException e) {
//            String mensaje = "Error al acceder a la base de datos. No se pudo actualizar el estado del Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        } catch (Exception e) {
//            String mensaje = "Error interno inesperado del servidor. No se pudo actualizar el estado del Tipo de Documento.";
//            responseGlobal = new ResponseGlobal(false, mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>(responseGlobal, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
