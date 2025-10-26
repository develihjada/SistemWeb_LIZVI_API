/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;



import com.Proyecto.Colegio.Repository.ProductoRepository;
import com.Proyecto.Colegio.dto.ProductoListaDTO;
import com.Proyecto.Colegio.dto.ProductoListaDetalleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import java.util.List;
/**
 *
 * @author Claudio Cruzado
 */
@Service
@Transactional
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public List<ProductoListaDTO> listar(int estado, int idfamilia, int idsubfamilia) {
        return productoRepository.mostrarProductos(estado, idfamilia, idsubfamilia);
    }
    
    public void guardar(Request.RequestcrearProducto dto) {
        productoRepository.insertarProducto(dto.getProducto(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getStock(),
                dto.getIdsubfamilia(),
                dto.getIdunidadmedida(),
                dto.getIdmarca(),
                dto.getImagen());
    }
    
    @Transactional(readOnly = true)
    public ProductoListaDetalleDTO detalle(int id) {
        return productoRepository.detalleProducto(id);
    }
    
    public void actualizar(Request.RequestactualizarProducto dto) {
        productoRepository.actualizarProducto(dto.getId(),
                dto.getProducto(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getStock(),
                dto.getEstado(),
                dto.getIdsubfamilia(),
                dto.getIdunidadmedida(),
                dto.getIdmarca(),
                dto.getImagen());
    }
    
    public void actualizarEstado(Request.RequestactuializarEstadoProducto dto) {
        productoRepository.actualizarEstadoPoducto(dto.getId(),
                dto.getEstado());
    }
    
}
