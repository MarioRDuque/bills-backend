package com.billsbackend.controlador;

import com.billsbackend.util.BusquedaPaginada;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface GenericoControlador<Entidad, TipoLlave> {

	public ResponseEntity<BusquedaPaginada> busquedaPaginada(HttpServletRequest request, Long pagina, Long cantidadPorPagina, Map<String, Object> parametros);

	public ResponseEntity crear(HttpServletRequest request, Entidad entidad);
	
	public ResponseEntity obtener(HttpServletRequest request, TipoLlave id);

	public ResponseEntity actualizar(HttpServletRequest request, Entidad entidad);

	public ResponseEntity eliminarLogica(HttpServletRequest request, TipoLlave entidadId);
        
	public ResponseEntity eliminarFisica(HttpServletRequest request, TipoLlave entidadId);

	public ResponseEntity listarTodos(HttpServletRequest request);
        
	public ResponseEntity listarVigentes(HttpServletRequest request);
        
	public ResponseEntity listarNoVigentes(HttpServletRequest request);
	
	public Entidad obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada);
	
}
