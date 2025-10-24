/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */

@Setter
@Getter
public class DetalleVentaDTO {
    private int id;
    private int idventa;
    private int idproducto;
    private BigDecimal  cantidad;
    private BigDecimal  subtotal;
}
