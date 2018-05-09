
package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Persona;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.PersonaServicio;
import com.billsbackend.util.Criterio;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

/**
 *
 * @author PCQUISPE
 */
@Service
public class PersonaServicioImpl  extends GenericoServicioImpl<Persona,Long> implements PersonaServicio{
    
    private final Logger loggerServicio = LoggerFactory.getLogger(getClass());
    @Autowired
    private GenericoDao<Persona, Long> personaDao;
     
    public PersonaServicioImpl(GenericoDao<Persona, Long> baseHibernate) {
        super(baseHibernate);
    }

    @Override
    public Persona validar(String nombre) throws GeneralException {
       
        Criterio filtro;
        filtro = Criterio.forClass(Persona.class);
        filtro.add(Restrictions.eq("nomnbre",nombre));
        Persona p = personaDao.obtenerPorCriteriaSinProyeccionesDistinct(filtro);
        if (p != null) {
            throw new GeneralException("Clinete persona no esta registada", "La Persona no existe", loggerServicio);
        }
        return p;   
    }
    
    
}
