/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Repository;

import com.Proyecto.Colegio.Entity.Producto;
import com.Proyecto.Colegio.dto.ProductoListaDTO;
import com.Proyecto.Colegio.dto.ProductoListaDetalleDTO;
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
    List<ProductoListaDTO> mostrarProductos(@Param("estado") int estado, @Param("idfamilia") int idfamilia, @Param("idsubfamilia") int idsubfamilia);

    @Procedure(name = "InsertarProducto")
    void insertarProducto(@Param("producto") String producto,
            @Param("descripcion") String descripcion,
            @Param("precio") float precio,
            @Param("stock") float stock,
            @Param("idsubfamilia") int idsubfamilia,
            @Param("idunidadmedida") int idunidadmedida,
            @Param("idmarca") int idmarca,
            @Param("imagen") String imagen);
    
    @Procedure(name = "DetalleProducto")
    ProductoListaDetalleDTO detalleProducto(@Param("id") int id);
    
    @Procedure(name = "ActualizarProducto")
    void actualizarProducto(@Param("id") int id,
            @Param("producto") String producto,
            @Param("descripcion") String descripcion,
            @Param("precio") float precio,
            @Param("stock") float stock,
            @Param("estado") int estado,
            @Param("idsubfamilia") int idsubfamilia,
            @Param("idunidadmedida") int idunidadmedida,
            @Param("idmarca") int idmarca,
            @Param("imagen") String imagen);
    
    @Procedure(name = "ActualizarEstadoPoducto")
    void actualizarEstadoPoducto(@Param("id") int id,
            @Param("estado") int estado);
    

}
