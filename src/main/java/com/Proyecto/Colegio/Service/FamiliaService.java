/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;

import com.Proyecto.Colegio.Entity.Familia;
import com.Proyecto.Colegio.Repository.FamiliaRepository;
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
public class FamiliaService {
    
    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional(readOnly = true)
    public List<Familia> listar(int estado) {
        return familiaRepository.mostrarFamilia(estado);
    }
    
//    public List<TipoDocumento> existe(String descripcion) {
//        return familiaRepository.existeTipoDocumento(descripcion);
//    }
//    
//    public List<TipoDocumento> existeId(int id) {
//        return familiaRepository.existeIdTipoDocumento(id);
//    }
//
//    public void guardar(RequestcrearDocumento dto) {
//        familiaRepository.insertarTipoDocumento(dto.getDescripcion());
//    }
//
//    public void actualizar(RequestactualizarDocumento dto) {
//        familiaRepository.actualizarTipoDocumento(dto.getId(), dto.getDescripcion());
//    }
//
//    public void actualizarEstado(Integer id, int nuevoEstado) {
//        familiaRepository.actualizarEstadoTipoDocumento(id, nuevoEstado);
//    }
    
}
