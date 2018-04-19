/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author PROPIETARIO
 */
@Data
@Embeddable
public class MenutipousuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenu")
    private long idmenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipousuario")
    private long idtipousuario;

    public MenutipousuarioPK() {
    }

    public MenutipousuarioPK(long idmenu, long idtipousuario) {
        this.idmenu = idmenu;
        this.idtipousuario = idtipousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmenu;
        hash += (int) idtipousuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenutipousuarioPK)) {
            return false;
        }
        MenutipousuarioPK other = (MenutipousuarioPK) object;
        if (this.idmenu != other.idmenu) {
            return false;
        }
        if (this.idtipousuario != other.idtipousuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.billsbackend.entidades.MenutipousuarioPK[ idmenu=" + idmenu + ", idtipousuario=" + idtipousuario + " ]";
    }
    
}
