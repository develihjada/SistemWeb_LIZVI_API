/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;

import com.Proyecto.Colegio.Entity.Familia;
import com.Proyecto.Colegio.Entity.UnidadMedida;
import com.Proyecto.Colegio.Repository.UnidadMedidaRepository;
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
public class UnidadMedidaService {
    
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @Transactional(readOnly = true)
    public List<UnidadMedida> listar(int estado) {
        return unidadMedidaRepository.mostrarUnidadMedida(estado);
    }
}
