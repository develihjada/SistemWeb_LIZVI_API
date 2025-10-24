/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;

import Request.RequestcrearDetalleVenta;
import Request.RequestcrearVenta;
import com.Proyecto.Colegio.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Claudio Cruzado
 */
@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public void guardar(RequestcrearVenta dto) {
        // Insertar la venta principal y obtener el ID generado
        Object result = ventaRepository.insertarVenta(
                dto.getFechaventa(),
                dto.getIdcliente(),
                dto.getTotal()
        );

        Integer idVenta = null;
        if (result != null) {
            if (result instanceof Number) {
                idVenta = ((Number) result).intValue();
            } else {
                throw new RuntimeException("No se pudo obtener el ID de la venta.");
            }
        } else {
            throw new RuntimeException("La inserción de la venta no devolvió un ID.");
        }

        // Insertar los detalles de la venta y actualizar el stock de cada producto
        for (RequestcrearDetalleVenta detalle : dto.getDetalles()) {
            // Insertar detalle
            ventaRepository.insertarDetalleVenta(
                    idVenta,
                    detalle.getIdproducto(),
                    detalle.getCantidad(),
                    detalle.getSubtotal()
            );

            // Disminuir el stock del producto vendido
            ventaRepository.actualizarStockProducto(
                    detalle.getIdproducto(),
                    detalle.getCantidad()
            );
        }
    }

}
