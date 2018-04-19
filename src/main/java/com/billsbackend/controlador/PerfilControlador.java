/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.controlador;


import com.billsbackend.entidades.Usuario;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.PerfilServicio;
import com.billsbackend.servicio.GenericoServicio;
import com.billsbackend.util.BillsUtil;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Mensaje;
import com.billsbackend.util.Respuesta;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LUIS ORTIZ
 */
@RestController
@RequestMapping("/perfil")
public class PerfilControlador extends GenericoControladorImpl<Usuario, String> implements GenericoControlador<Usuario,String>{

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    
    public PerfilControlador(GenericoServicio<Usuario, String> servicio, String nombreEntidad) {
        super(servicio, nombreEntidad);
    }

    @Override
    public Usuario obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
