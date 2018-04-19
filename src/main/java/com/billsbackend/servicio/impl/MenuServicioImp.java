/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Menu;
import com.billsbackend.entidades.Menuopcion;
import com.billsbackend.entidades.Tipousuario;
import com.billsbackend.entidades.Tipousuariomenuopcion;
import com.billsbackend.entidades.Usuariotipousuario;
import com.billsbackend.entidades.TipousuariomenuopcionPK;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.MenuServicio;
import com.billsbackend.util.Criterio;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
/**
 *
 * @author dev-out-03
 */

@Service
@Transactional
public class MenuServicioImp extends GenericoServicioImpl<Menu, Long> implements MenuServicio {

    private final Logger loggerServicio = LoggerFactory.getLogger(getClass());
    @Autowired
    private GenericoDao<Usuariotipousuario, Long> usuarioAccesoDao;
    @Autowired
    private GenericoDao<Tipousuario, TipousuariomenuopcionPK> menuTipousuarioDao;

    public MenuServicioImp(GenericoDao<Menu, Long> genericoHibernate) {
        super(genericoHibernate);
    }

    @Override
    public List<Menu> listarMenus(String login) throws GeneralException {
        List<Long> ltu = obtenerTiposDeUsuario(login);
        if (ltu.isEmpty()) {
            throw new GeneralException("El usuario no tiene tipos de usuario", "No existe tipos.", loggerServicio);
        }
        List<Menu> lm = obtenerMenusPadresPorTipoDeUsuario(ltu);
        obtenerSubmenus(lm, ltu);
        return lm;
    }
    

    private List<Long> obtenerTiposDeUsuario(String login) {
        List<Long> ids = new ArrayList<>();
        Criterio filtro;
        filtro = Criterio.forClass(Usuariotipousuario.class);
        filtro.add(Restrictions.eq("estado", Boolean.TRUE));
        filtro.createAlias("tipousuario", "tu");
        filtro.createAlias("usuario", "u");
        filtro.add(Restrictions.eq("u.userId", login));
        List<Usuariotipousuario> ua = usuarioAccesoDao.buscarPorCriteriaSinProyecciones(filtro);
        for (int i = 0; i < ua.size(); i++) {
            ids.add(ua.get(i).getTipousuario().getId());
        }
        return ids;
    }

    private List<Menu> obtenerMenusPadresPorTipoDeUsuario(List<Long> ids) {
        Criterio filtro;
        filtro = Criterio.forClass(Tipousuariomenuopcion.class);
        filtro.add(Restrictions.eq("estado", Boolean.TRUE));
        filtro.createAlias("menuopcion", "imo");
        filtro.createAlias("tipousuario", "tu");
        filtro.createAlias("imo.idmenu", "menu");
        filtro.add(Restrictions.isNull("menu.idpadre"));
        filtro.add(Restrictions.in("tipousuariomenuopcionPK.idtipousuario",ids));
        filtro.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.property("tipousuariomenuopcionPK.idmenuopcion")))
                .add(Projections.property("menu.id"), "id")
                .add(Projections.property("menu.nombre"), "nombre")
                .add(Projections.property("menu.icono"), "icono")
                .add(Projections.property("menu.estado"), "estado")
                .add(Projections.property("menu.url"), "url")
                .add(Projections.property("menu.idpadre"), "idpadre")
        );
       // filtro.addOrder(Order.asc("menu.orden"));
        List<Menu> lmtu = menuTipousuarioDao.proyeccionPorCriteria(filtro, Menu.class);
        return lmtu;
    }

    private void obtenerSubmenus(List<Menu> lm, List<Long> ids) {
        for (int i = 0; i < lm.size(); i++) {
            Criterio filtro;
            filtro = Criterio.forClass(Tipousuariomenuopcion.class);
            filtro.add(Restrictions.eq("estado", Boolean.TRUE));
            filtro.createAlias("idmenu", "menu");
            filtro.add(Restrictions.eq("menu.idpadre",lm.get(i).getId()));
            filtro.add(Restrictions.in("tipousuariomenuopcionPK.idtipousuario",ids));
            filtro.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.property("tipousuariomenuopcionPK.idmenu")))
                .add(Projections.property("menu.id"), "id")
                .add(Projections.property("menu.nombre"), "nombre")
                .add(Projections.property("menu.icono"), "icono")
                .add(Projections.property("menu.estado"), "estado")
                .add(Projections.property("menu.url"), "url")
                .add(Projections.property("menu.idpadre"), "idpadre")
            );
            List<Menu> lmhijos = menuTipousuarioDao.proyeccionPorCriteria(filtro, Menu.class);
            apilarOpciones(lmhijos, ids);
            lm.get(i).setMenuList(lmhijos);
            obtenerSubmenus(lmhijos, ids);
        }
    }

    private void apilarOpciones(List<Menu> lmhijos, List<Long> ids) {
        for (int i = 0; i < lmhijos.size(); i++) {
            Criterio filtro;
            filtro = Criterio.forClass(Tipousuariomenuopcion.class);
            filtro.add(Restrictions.eq("estado", Boolean.TRUE));
            filtro.createAlias("idmenu", "menu");
            filtro.add(Restrictions.eq("menu.id",lmhijos.get(i).getId()));
            filtro.add(Restrictions.in("tipousuariomenuopcionPK.idtipousuario",ids));
            filtro.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.property("tipousuariomenuopcionPK.idmenu")))
                .add(Projections.property("menuopcion.id"), "id")
                .add(Projections.property("menuopcion.icono"), "icono")
                .add(Projections.property("menuopcion.url"), "url")
                .add(Projections.property("menuopcion.descripcion"), "descripcion")
                .add(Projections.property("menuopcion.estado"), "estado")
                .add(Projections.property("menuopcion.idmenu"), "idmenu")
            );
            List<Menuopcion> lmOpcion = menuTipousuarioDao.proyeccionPorCriteria(filtro, Menuopcion.class);
            lmhijos.get(i).setMenuopcionList(lmOpcion);
            obtenerSubmenus(lmhijos, ids);
        }
    }
    
}
