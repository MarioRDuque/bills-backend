/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Usuario;
import com.billsbackend.servicio.PerfilServicio;
import com.billsbackend.util.Criterio;
import java.io.IOException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LUIS ORTIZ
 */
@Service
public class PerfilServicioImpl extends GenericoServicioImpl<Usuario, String> implements PerfilServicio{

    @Autowired
    private GenericoDao<Usuario, Long> perfilDao;
    public PerfilServicioImpl(GenericoDao<Usuario, String> baseHibernate) {
        super(baseHibernate);
    }

    @Override
    public Usuario obtener(String id) {
        Criterio filtro;
        filtro = Criterio.forClass(Usuario.class);
        filtro.add(Restrictions.eq("userId", id));
        Usuario u = perfilDao.obtenerPorCriteriaSinProyeccionesDistinct(filtro);

        if (u!=null) {
            u.setUsuariotipousuarioList(null);
            if (u.getIdpersona()!=null) {
                u.getIdpersona().setDocpersonaList(null);
            }
        }
        return u; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(MultipartFile file, String userId) throws IOException{
        Usuario u=obtener(userId);
        u.setFoto(file.getBytes());
        perfilDao.actualizar(u);
    }


   
    
}
