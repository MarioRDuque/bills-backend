/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio;

import com.billsbackend.entidades.Usuario;

/**
 *
 * @author LUIS ORTIZ
 */
public interface UsuarioServicio extends GenericoServicio<Usuario, Long >{

    public boolean validarNuevaPassword(String username, String passwordTipeada);
    public Usuario actualizarClaves(String username, String pwtipeada);
    
}
