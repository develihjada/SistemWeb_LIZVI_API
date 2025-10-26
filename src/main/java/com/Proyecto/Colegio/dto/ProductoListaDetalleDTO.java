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
public class ProductoListaDetalleDTO {
    private int id;
    private String producto;
    private String descripcion;
    private float precio;
    private float stock;
    private int estado;
    private String imagen;
    private int idsubfamilia;
    private String subfamilia;
    private int idfamilia;
    private String familia;
    private int idmarca;
    private String marca;
    private int idunidadmedida;
    private String unidadmedida;
}
