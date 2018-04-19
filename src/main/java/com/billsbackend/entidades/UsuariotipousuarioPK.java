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
public class UsuariotipousuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private String idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipousuario")
    private long idtipousuario;

    public UsuariotipousuarioPK() {
    }

    public UsuariotipousuarioPK(String idusuario, long idtipousuario) {
        this.idusuario = idusuario;
        this.idtipousuario = idtipousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtipousuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariotipousuarioPK)) {
            return false;
        }
        UsuariotipousuarioPK other = (UsuariotipousuarioPK) object;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (this.idtipousuario != other.idtipousuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.UsuariotipousuarioPK[ idusuario=" + idusuario + ", idtipousuario=" + idtipousuario + " ]";
    }

}
