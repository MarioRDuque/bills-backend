package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Empresa;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.EmpresaServicio;
import com.billsbackend.util.Criterio;
import java.util.Date;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServicioImpl extends GenericoServicioImpl<Empresa, Long> implements EmpresaServicio {

    private final Logger loggerServicio = LoggerFactory.getLogger(getClass());
    @Autowired
    private GenericoDao<Empresa, Long> empresaDao;

    public EmpresaServicioImpl(GenericoDao<Empresa, Long> genericoHibernate) {
        super(genericoHibernate);
    }
    
    @Override
    public Empresa validar(String ruc) throws GeneralException{
        Criterio filtro;
        filtro = Criterio.forClass(Empresa.class);
        filtro.add(Restrictions.eq("ruc", ruc));
        filtro.add(Restrictions.gt("fechacaducidad", new Date()));
        Empresa e = empresaDao.obtenerPorCriteriaSinProyeccionesDistinct(filtro);
        if (e!=null && !e.isEstado()) {
            throw new GeneralException("Esta empresa no esta habilitada", "La empresa fue dada de baja.", loggerServicio);
        }
        return e;
    }
    
}
