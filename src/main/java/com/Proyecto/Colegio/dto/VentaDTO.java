/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */
@Setter
@Getter
public class VentaDTO {
    private int id;
    private Date fechaventa;
    private int idcliente;
    private BigDecimal total;
}
