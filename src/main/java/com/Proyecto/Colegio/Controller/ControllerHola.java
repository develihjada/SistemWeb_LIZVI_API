/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Colegio.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Claudio Cruzado
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Hola")
public class ControllerHola {
    /**
     * Endpoint que responde a la petición GET en la URL:
     * /Hola/mensaje
     */
    @GetMapping("/mensaje")
    public String saludar() {
        return "Hola, tu API está funcionando correctamente!";
    }
}
