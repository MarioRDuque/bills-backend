/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author PROPIETARIO
 */
@Data
@Entity
@Table(name = "menutipousuario")
@NamedQueries({
    @NamedQuery(name = "Menutipousuario.findAll", query = "SELECT m FROM Menutipousuario m")})
public class Menutipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenutipousuarioPK menutipousuarioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idmenu", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "idtipousuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipousuario tipousuario;

    public Menutipousuario() {
    }

    public Menutipousuario(MenutipousuarioPK menutipousuarioPK) {
        this.menutipousuarioPK = menutipousuarioPK;
    }

    public Menutipousuario(MenutipousuarioPK menutipousuarioPK, boolean estado) {
        this.menutipousuarioPK = menutipousuarioPK;
        this.estado = estado;
    }

    public Menutipousuario(long idmenu, long idtipousuario) {
        this.menutipousuarioPK = new MenutipousuarioPK(idmenu, idtipousuario);
    }

    public MenutipousuarioPK getMenutipousuarioPK() {
        return menutipousuarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menutipousuarioPK != null ? menutipousuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menutipousuario)) {
            return false;
        }
        Menutipousuario other = (Menutipousuario) object;
        if ((this.menutipousuarioPK == null && other.menutipousuarioPK != null) || (this.menutipousuarioPK != null && !this.menutipousuarioPK.equals(other.menutipousuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.billsbackend.entidades.Menutipousuario[ menutipousuarioPK=" + menutipousuarioPK + " ]";
    }
    
}
