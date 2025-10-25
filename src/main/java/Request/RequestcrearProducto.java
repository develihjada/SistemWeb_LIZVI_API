/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Request;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Claudio Cruzado
 */

@Getter
@Setter
public class RequestcrearProducto {
    
    private String producto;
    private String descripcion;
    private float precio;
    private float stock;
    private int idsubfamilia;
    private int idunidadmedida;
    private int idmarca;
    private String imagen;
}
