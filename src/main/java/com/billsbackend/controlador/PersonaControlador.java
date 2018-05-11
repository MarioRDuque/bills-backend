package com.billsbackend.controlador;

import com.billsbackend.entidades.Persona;
import com.billsbackend.servicio.PersonaServicio;
import com.billsbackend.util.BusquedaPaginada;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PCQUISPE
 */
@RestController
@RequestMapping("/persona")
public class PersonaControlador extends GenericoControladorImpl<Persona,Long> implements GenericoControlador<Persona, Long>{
    
    public PersonaControlador(PersonaServicio personaServicio) {
        super(personaServicio, "persona");
    }

    @Override
    public Persona obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
