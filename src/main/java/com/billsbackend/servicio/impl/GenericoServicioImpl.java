package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.servicio.GenericoServicio;
import java.lang.reflect.ParameterizedType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericoServicioImpl<Entidad, TipoLlave> implements GenericoServicio<Entidad, TipoLlave> {

    private final GenericoDao<Entidad, TipoLlave> genericoDao;

    @SuppressWarnings("unused")
    private Class<Entidad> domainClass = null;

    @SuppressWarnings("unchecked")
    protected GenericoServicioImpl(GenericoDao<Entidad, TipoLlave> baseHibernate) {
        this.genericoDao = baseHibernate;
        this.domainClass = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Entidad obtener(TipoLlave id) {
        return this.genericoDao.obtener(this.domainClass, id);
    }

}
