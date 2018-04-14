package com.billsbackend.controlador;

import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.GenericoServicio;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Mensaje;
import com.billsbackend.util.Respuesta;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public abstract class GenericoControladorImpl<Entidad, TipoLlave> implements GenericoControlador<Entidad, TipoLlave> {

    private final org.slf4j.Logger loggerControlador = LoggerFactory.getLogger(getClass());
    private GenericoServicio<Entidad, TipoLlave> servicio;

    public GenericoControladorImpl(GenericoServicio<Entidad, TipoLlave> servicio, String nombreEntidad) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "pagina/{pagina}/cantidadPorPagina/{cantidadPorPagina}", method = RequestMethod.POST)
    @Override
    public ResponseEntity<BusquedaPaginada> busquedaPaginada(HttpServletRequest request, @PathVariable("pagina") Long pagina, @PathVariable("cantidadPorPagina") Long cantidadPorPagina, @RequestBody Map<String, Object> parametros) {
        BusquedaPaginada busquedaPaginada;
        Entidad entidadBuscar;

        busquedaPaginada = new BusquedaPaginada();
        busquedaPaginada.setBuscar(parametros);
        entidadBuscar = obtenerEntidadBuscar(busquedaPaginada);

        busquedaPaginada.setPaginaActual(pagina);
        busquedaPaginada.setCantidadPorPagina(cantidadPorPagina);
        busquedaPaginada = servicio.busquedaPaginada(entidadBuscar, busquedaPaginada);
        return new ResponseEntity<>(busquedaPaginada, HttpStatus.OK);
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    @Override
    public ResponseEntity crear(HttpServletRequest request, @RequestBody Entidad entidad) {
        Respuesta resp = new Respuesta();
        if (entidad != null) {
            try {
                Entidad e = servicio.crear(entidad);
                if (e != null ) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(e);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_GUARDAR, "Guardar retorno nulo", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "listarTodos", method = RequestMethod.GET)
    @Override
    public ResponseEntity listarTodos(HttpServletRequest request) {
        Respuesta resp = new Respuesta();
            try {
                List<Entidad> entidades = servicio.listarTodos();
                if (entidades != null && !entidades.isEmpty()) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(entidades);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_LISTAR, "Error al listar", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "listarVigentes", method = RequestMethod.GET)
    @Override
    public ResponseEntity listarVigentes(HttpServletRequest request) {
        Respuesta resp = new Respuesta();
            try {
                List<Entidad> entidades = servicio.listarVigentes();
                if (entidades != null && !entidades.isEmpty()) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(entidades);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_LISTAR, "Error al listar", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "listarNoVigentes", method = RequestMethod.GET)
    @Override
    public ResponseEntity listarNoVigentes(HttpServletRequest request) {
        Respuesta resp = new Respuesta();
            try {
                List<Entidad> entidades = servicio.listarNoVigentes();
                if (entidades != null && !entidades.isEmpty()) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(entidades);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_LISTAR, "Error al listar", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @Override
    public ResponseEntity obtener(HttpServletRequest request, @PathVariable("id") TipoLlave id) {
        Respuesta resp = new Respuesta();
            try {
                Entidad entidad = servicio.obtener(id);
                if (entidad != null) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(entidad);
                } else {
                    throw new GeneralException(Mensaje.NO_EXISTEN_DATOS, "Error al listar", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);        
    }

    @RequestMapping(value = "actualizar", method = RequestMethod.PUT)
    @Override
    public ResponseEntity actualizar(HttpServletRequest request, @RequestBody Entidad entidad) {
        Respuesta resp = new Respuesta();
        if (entidad != null) {
            try {
                Entidad e = servicio.actualizar(entidad);
                if (e != null ) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(e);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_ACTUALIZAR, "Guardar retorno nulo", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @Override
    public ResponseEntity eliminarLogica(HttpServletRequest request, @PathVariable("id") TipoLlave entidadId) {
        Respuesta resp = new Respuesta();
            try {
                TipoLlave e = servicio.eliminarLogica(entidadId);
                if (e != null ) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(e);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_ELIMINAR, "Guardar retorno nulo", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity eliminarFisica(HttpServletRequest request, @PathVariable("id") TipoLlave entidadId) {
        Respuesta resp = new Respuesta();
            try {
                TipoLlave e = servicio.eliminarFisica(entidadId);
                if (e != null ) {
                    resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                    resp.setOperacionMensaje(Mensaje.OPERACION_CORRECTA);
                    resp.setExtraInfo(e);
                } else {
                    throw new GeneralException(Mensaje.ERROR_CRUD_ELIMINAR, "Guardar retorno nulo", loggerControlador);
                }
            } catch (Exception e) {
                throw e;
            }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
