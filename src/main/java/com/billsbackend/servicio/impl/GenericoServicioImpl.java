package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.servicio.GenericoServicio;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Criterio;
import java.lang.reflect.ParameterizedType;
import java.util.List;
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
    
    @Override
    public void grabarTodos(List<Entidad> list){
        
    }

    @Override
    public List<Entidad> listarTodos(){
        return null;
    }
      
    @Override
    public List<Entidad> listarVigentes(){
        return null;
    }
     
    @Override
    public List<Entidad> listarNoVigentes(){
        return null;
    }

    @Override
    public List<Entidad> buscarPorCriteria(Criterio filtro){
        return null;
    }
	
    @Override
    public BusquedaPaginada busquedaPaginada(Entidad entidadBuscar, BusquedaPaginada busquedaPaginada){
        return null;
    }
	
    @Override
    public Entidad crear(Entidad entidad){
        return null;
    }
        
    @Override
    public Entidad actualizar(Entidad entidad){
        return genericoDao.actualizar(entidad);
    }
        
    @Override
    public TipoLlave eliminarLogica(TipoLlave entidadId){
        return null;
    }
        
    @Override
    public TipoLlave eliminarFisica(TipoLlave entidadId){
        return null;
    }

}
