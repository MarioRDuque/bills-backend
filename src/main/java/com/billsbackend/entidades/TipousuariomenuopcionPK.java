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
 * @author francis
 */
@Data
@Embeddable
public class TipousuariomenuopcionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipousuario")
    private long idtipousuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmenuopcion")
    private long idmenuopcion;

    public TipousuariomenuopcionPK() {
    }

    public TipousuariomenuopcionPK(long idtipousuario, long idmenuopcion) {
        this.idtipousuario = idtipousuario;
        this.idmenuopcion = idmenuopcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtipousuario;
        hash += (int) idmenuopcion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipousuariomenuopcionPK)) {
            return false;
        }
        TipousuariomenuopcionPK other = (TipousuariomenuopcionPK) object;
        if (this.idtipousuario != other.idtipousuario) {
            return false;
        }
        if (this.idmenuopcion != other.idmenuopcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.TipousuariomenuopcionPK[ idtipousuario=" + idtipousuario + ", idmenuopcion=" + idmenuopcion + " ]";
    }
    
}
