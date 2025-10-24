/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Repository;

import com.Proyecto.Colegio.Entity.Venta;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Claudio Cruzado
 */
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "EXEC Vender :fechaventa, :idcliente, :total", nativeQuery = true)
    Object insertarVenta(
            @Param("fechaventa") Date fechaventa,
            @Param("idcliente") Integer idcliente,
            @Param("total") BigDecimal total
    );

    @Modifying
    @Query(value = "EXEC VentaDetalle :idventa, :idproducto, :cantidad, :subtotal", nativeQuery = true)
    void insertarDetalleVenta(
            @Param("idventa") Integer idventa,
            @Param("idproducto") Integer idproducto,
            @Param("cantidad") BigDecimal cantidad,
            @Param("subtotal") BigDecimal subtotal
    );

    // Actualiza el stock del producto
    @Procedure(name = "ActualizarStockProducto")
    void actualizarStockProducto(
            @Param("idproducto") Integer idproducto,
            @Param("cantidad") BigDecimal cantidad
    );

}
