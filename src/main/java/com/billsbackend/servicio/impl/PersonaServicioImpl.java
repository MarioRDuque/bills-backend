package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Persona;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.PersonaServicio;
import com.billsbackend.util.Criterio;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author LUIS ORTIZ
 */
@Service
public class PersonaServicioImpl extends GenericoServicioImpl<Persona, Long> implements PersonaServicio {

    private final Logger loggerServicio = LoggerFactory.getLogger(getClass());
    @Autowired
    private GenericoDao<Persona, Long> personaDao;

    public PersonaServicioImpl(GenericoDao<Persona, Long> baseHibernate) {
        super(baseHibernate);
    }

    @Override
    public Persona validar(String ruc) throws GeneralException {
        Criterio filtro;
        filtro = Criterio.forClass(Persona.class);
        filtro.add(Restrictions.eq("rucempresa",ruc));
        Persona p = personaDao.obtenerPorCriteriaSinProyeccionesDistinct(filtro);
        if (p != null) {
            throw new GeneralException("La persona no esta registrada", "La Persona no existe", loggerServicio);
        }
        return p;   
    }
     //metodo guardar datos personales
    @Override
    public Persona crear(Persona entidad) {
        if (entidad!= null) {
            entidad.setIdubigeo(null);
            entidad.setCliente(true);
            entidad.setProveedor(true);
            entidad.setEstado(true);
            return personaDao.insertar(entidad);
        } else {
            throw new GeneralException("No Existe ruc de empresa", "campo obligatorio", loggerServicio);
        }
    }

}
