/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.controlador;

import com.billsbackend.entidades.Usuario;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.GenericoServicio;
import com.billsbackend.servicio.UsuarioServicio;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Mensaje;
import com.billsbackend.util.Respuesta;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LUIS ORTIZ
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioControlador extends GenericoControladorImpl<Usuario, Long> implements GenericoControlador<Usuario, Long> {

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio servicio) {
        super(servicio, "usuario");
    }

    @Override
    public Usuario obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping("validarPassword/{username}/{passwordTipeada}")
    public ResponseEntity validarPassword(@PathVariable String username, @PathVariable String passwordTipeada) throws GeneralException {
        Respuesta resp = new Respuesta();
        try {
            resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
            if (usuarioServicio.validarNuevaPassword(username, passwordTipeada)) {
                resp.setExtraInfo(true);
                resp.setOperacionMensaje("Guardando");
            } else {
                resp.setExtraInfo(false);
                resp.setOperacionMensaje("La contraseña ingresada no coincide con la actual");
            }
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            loggerControlador.error(e.getMessage());
            throw e;
        }
    }

    ;
    
          @GetMapping("actualizarclave/{username}/{passwordTipeada}")
    public ResponseEntity actualizarclave(@PathVariable("username") String username, @PathVariable("passwordTipeada") String passwordTipeada) throws GeneralException {
        Respuesta resp = new Respuesta();
        try {
            Usuario guardado = usuarioServicio.actualizar(username, passwordTipeada);
            if (guardado != null) {
                resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                resp.setOperacionMensaje(Mensaje.OP_CORRECTA);
                resp.setExtraInfo(guardado.getUserId());
            } else {
                throw new GeneralException(Mensaje.ERROR_CRUD, "Existe usuario vacío", loggerControlador);
            }
        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
;

}
