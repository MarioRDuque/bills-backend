/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio;

import com.billsbackend.entidades.Usuario;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LUIS ORTIZ
 */
public interface PerfilServicio extends GenericoServicio<Usuario, String>{

    public void insertar(MultipartFile file, String userId) throws IOException;
    
}
