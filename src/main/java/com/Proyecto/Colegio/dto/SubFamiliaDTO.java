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
public class SubFamiliaDTO {
    private int id;
    private String descripcion;
    private String familia;
    private int estado;

    public SubFamiliaDTO() {
    }
    
    
}
