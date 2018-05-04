/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Usuario;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.UsuarioServicio;
import com.billsbackend.util.Criterio;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author LUIS ORTIZ
 */
@Service
public class UsuarioServicioImpl extends GenericoServicioImpl<Usuario, Long> implements UsuarioServicio{
    
     @Autowired
    private GenericoDao<Usuario, Long> usuarioDao;

    public UsuarioServicioImpl(GenericoDao<Usuario, Long> baseHibernate) {
        super(baseHibernate);
    }

    @Override
    public boolean validarNuevaPassword(String username, String passwordTipeada) throws GeneralException {
        Usuario usuario = this.show(username);
        if (usuario != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.matches(passwordTipeada, usuario.getPassword());
        }
        return false;
    }

    private Usuario show(String username) {
        Criterio filtro;
        filtro = Criterio.forClass(Usuario.class);
        filtro.add(Restrictions.eq("userId", username));
        Usuario u = usuarioDao.obtenerPorCriteriaSinProyeccionesDistinct(filtro);

        return u;
    }
    
    @Override
    public Usuario actualizar(Usuario u) throws GeneralException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        u.setPassword(encoder.encode(u.getPassword()));
        return usuarioDao.actualizar(u);
    }

    @Override
    public Usuario actualizar(String username, String pwtipeada) {
        Usuario usuario = this.show(username);
        if (usuario!=null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            usuario.setPassword(encoder.encode(pwtipeada));
            return usuarioDao.actualizar(usuario);
        } else {
            return null;
        }
    }
    
}
