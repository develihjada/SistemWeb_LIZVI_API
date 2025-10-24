/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Entity;

import com.Proyecto.Colegio.dto.SubFamiliaDTO;
import jakarta.persistence.*;
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
    name = "MostrarSubFamilia",
    procedureName = "MostrarSubFamilia",
    resultSetMappings = "MappingSubfamiliaDTO",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "estado", type = Integer.class)
    }
)

@SqlResultSetMapping(
    name = "MappingSubfamiliaDTO",
    classes = {
        @ConstructorResult(
            targetClass = SubFamiliaDTO.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "descripcion", type = String.class),
                @ColumnResult(name = "familia", type = String.class),
                @ColumnResult(name = "estado", type = Integer.class)
            }
        )
    }
)

@Entity
@Table(name = "SubFamilia")
public class SubFamilia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "idfamilia")
    private Integer idfamilia;

    @Column(name = "estado")
    private int estado;

}
