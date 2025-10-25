/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Service;


import com.Proyecto.Colegio.Repository.SubFamiliaRepository;
import com.Proyecto.Colegio.dto.SubFamiliaDTO;
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
public class SubFamiliaService {

    @Autowired
    private SubFamiliaRepository subFamiliaRepository;

    @Transactional(readOnly = true)
    public List<SubFamiliaDTO> listar(int estado, int idfamilia) {
        return subFamiliaRepository.mostrarSubFamilia(estado, idfamilia);
    }
}
