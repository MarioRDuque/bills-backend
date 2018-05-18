/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.controlador;

import com.billsbackend.entidades.Usuario;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.PerfilServicio;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Respuesta;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LUIS ORTIZ
 */
@RestController
@RequestMapping("/perfil")
public class PerfilControlador extends GenericoControladorImpl<Usuario, String> implements GenericoControlador<Usuario, String> {

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    PerfilServicio perfilservicio;

    public PerfilControlador(PerfilServicio servicio) {
        super(servicio, "perfil");
    }

    @Override
    public Usuario obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/subir", method = RequestMethod.POST)
    public ResponseEntity subir(HttpServletRequest request,
            @RequestParam("file") MultipartFile file, 
            @RequestParam(name = "userid", required = false) String userid) throws GeneralException, IOException{
        Respuesta rsp = new Respuesta();
        if(file != null ){
            perfilservicio.insertar(file, userid);
            rsp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
            rsp.setOperacionMensaje("Operacion Exitosa");
            rsp.setExtraInfo(userid);
        }else{
            throw new GeneralException("Lista no disponible", "No hay datos", loggerControlador);
        }
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }

}
