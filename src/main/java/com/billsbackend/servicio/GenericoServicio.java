package com.billsbackend.servicio;

import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Criterio;
import java.util.List;

public interface GenericoServicio<Entidad, TipoLlave> {

	Entidad obtener(TipoLlave id);

	void grabarTodos(List<Entidad> list);

	List<Entidad> listarTodos();
        
	List<Entidad> listarVigentes();
        
	List<Entidad> listarNoVigentes();

	List<Entidad> buscarPorCriteria(Criterio filtro);
	
	public BusquedaPaginada busquedaPaginada(Entidad entidadBuscar, BusquedaPaginada busquedaPaginada);
	
	public Entidad crear(Entidad entidad);
        
	public Entidad actualizar(Entidad entidad);
        
	public TipoLlave eliminarLogica(TipoLlave entidadId);
        
	public TipoLlave eliminarFisica(TipoLlave entidadId);
	
}