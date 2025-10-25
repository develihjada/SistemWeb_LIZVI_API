/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;


import com.Proyecto.Colegio.Entity.Marca;
import com.Proyecto.Colegio.Repository.MarcaRepository;
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
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional(readOnly = true)
    public List<Marca> listar(int estado) {
        return marcaRepository.mostrarMarca(estado);
    }
}
