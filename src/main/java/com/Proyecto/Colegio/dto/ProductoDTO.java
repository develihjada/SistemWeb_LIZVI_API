/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */

@Setter
@Getter
public class ProductoDTO {
    private int id;
    private String producto;
    private String descripcion;
    private float precio;
    private float stock;
    private int idsubfamilia;
    private int idunidadmedida;
    private int idmarca;
    private int estado;
    private String imagen;
}
