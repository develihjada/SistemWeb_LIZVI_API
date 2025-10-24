/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Entity;

import com.Proyecto.Colegio.dto.ProductoListaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Claudio Cruzado
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedStoredProcedureQuery(
    name = "MostrarProductos",
    procedureName = "MostrarProductos",
    resultSetMappings = "MappingProductoListarDTO",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "estado", type = Integer.class)
    }
)
@SqlResultSetMapping(
    name = "MappingProductoListarDTO",
    classes = {
        @ConstructorResult(
            targetClass = ProductoListaDTO.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "producto", type = String.class),
                @ColumnResult(name = "descripcion", type = String.class),
                @ColumnResult(name = "precio", type = float.class),
                @ColumnResult(name = "stock", type = float.class),
                @ColumnResult(name = "estado", type = Integer.class),
                @ColumnResult(name = "imagen", type = String.class)
            }
        )
    }
)
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "producto")
    private String producto;

    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "precio")
    private float precio;

    @Column(name = "stock")
    private float stock;
    
    @Column(name = "idsubfamilia")
    private int idsubfamilia;
    
    @Column(name = "idunidadmedida")
    private int idunidadmedida;

    @Column(name = "idmarca")
    private int idmarca;

    @Column(name = "estado")
    private int estado;
    
    @Column(name = "imagen")
    private String imagen;
}
