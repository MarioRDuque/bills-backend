package com.billsbackend.controlador;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Persona;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.GenericoServicio;
import com.billsbackend.servicio.PersonaServicio;
import com.billsbackend.util.BusquedaPaginada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PCQUISPE
 */
@RestController
@RequestMapping("/persona")
public class PersonaControlador extends GenericoControladorImpl<Persona,Long> implements GenericoControlador<Persona, Long>{

    //declare variables
    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonaServicio personaServicio;
    
    @Autowired
    private GenericoDao<Persona,Long> personaDao;
    
    public PersonaControlador(PersonaServicio personaServicio) {
        super(personaServicio, "persona");
    }

    @Override
    public Persona obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    //metodo guardar datos personales
//    @RequestMapping(value = "guardar", method = RequestMethod.POST)
//    public Persona crear(Persona entidad) {
//        if (entidad.getNombre()!= null) {
//            entidad.setIdubigeo(0);
//            entidad.setCliente(true);
//            entidad.setProveedor(true);
//            entidad.setEstado(true);
//            return personaDao.insertar(entidad);
//        } else {
//            throw new GeneralException("No Existe persona cliente", "campo obligatorio", loggerControlador);
//        }
//    }
   
}
