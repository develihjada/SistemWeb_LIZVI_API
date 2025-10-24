/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Repository;


import com.Proyecto.Colegio.Entity.Producto;
import com.Proyecto.Colegio.dto.ProductoListaDTO;
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
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Procedure(name = "MostrarProductos")
    List<ProductoListaDTO> mostrarProductos(@Param("estado") int estado);
    
}
