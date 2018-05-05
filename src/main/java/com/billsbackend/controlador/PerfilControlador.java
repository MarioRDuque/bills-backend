/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.controlador;

import com.billsbackend.entidades.Usuario;
import com.billsbackend.servicio.PerfilServicio;
import com.billsbackend.util.BusquedaPaginada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LUIS ORTIZ
 */
@RestController
@RequestMapping("/perfil")
public class PerfilControlador extends GenericoControladorImpl<Usuario, String> implements GenericoControlador<Usuario, String> {

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    PerfilServicio servicio;

    public PerfilControlador(PerfilServicio servicio) {
        super(servicio, "perfil");
    }

    @Override
    public Usuario obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
