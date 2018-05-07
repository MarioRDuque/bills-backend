/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.servicio.impl;

import com.billsbackend.dao.GenericoDao;
import com.billsbackend.entidades.Persona;
import com.billsbackend.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LUIS ORTIZ
 */
@Service
public class PersonaServicioImpl extends GenericoServicioImpl<Persona, Long> implements PersonaServicio {

    @Autowired
    private GenericoDao<Persona, Long> personaDao;

    public PersonaServicioImpl(GenericoDao<Persona, Long> baseHibernate) {
        super(baseHibernate);
    }

}
