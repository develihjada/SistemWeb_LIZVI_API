/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Repository;


import com.Proyecto.Colegio.Entity.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Claudio Cruzado
 */
@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Integer> {

    @Procedure(name = "MostrarUnidadMedida")
    List<UnidadMedida> mostrarUnidadMedida(@Param("estado") int estado);

}
