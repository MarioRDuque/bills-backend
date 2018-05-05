/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.controlador;

import com.billsbackend.entidades.Persona;
import com.billsbackend.servicio.PersonaServicio;
import com.billsbackend.util.BusquedaPaginada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LUIS ORTIZ
 */
@RestController
@RequestMapping("/persona")
public class PersonaControlador extends GenericoControladorImpl<Persona, Long> implements GenericoControlador<Persona, Long> {

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    PersonaServicio servicio;

    public PersonaControlador(PersonaServicio servicio) {
        super(servicio, "persona");
    }

    @Override
    public Persona obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
