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

@Data
@Entity
@Table(name = "usuariotipousuario")
@NamedQueries({
    @NamedQuery(name = "Usuariotipousuario.findAll", query = "SELECT u FROM Usuariotipousuario u")})
public class Usuariotipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariotipousuarioPK usuariotipousuarioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idusuario", referencedColumnName = "login", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "idtipousuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipousuario tipousuario;

    public Usuariotipousuario() {
    }

    public Usuariotipousuario(UsuariotipousuarioPK usuariotipousuarioPK) {
        this.usuariotipousuarioPK = usuariotipousuarioPK;
    }

    public Usuariotipousuario(UsuariotipousuarioPK usuariotipousuarioPK, boolean estado) {
        this.usuariotipousuarioPK = usuariotipousuarioPK;
        this.estado = estado;
    }

    public Usuariotipousuario(String idusuario, long idtipousuario) {
        this.usuariotipousuarioPK = new UsuariotipousuarioPK(idusuario, idtipousuario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariotipousuarioPK != null ? usuariotipousuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariotipousuario)) {
            return false;
        }
        Usuariotipousuario other = (Usuariotipousuario) object;
        if ((this.usuariotipousuarioPK == null && other.usuariotipousuarioPK != null) || (this.usuariotipousuarioPK != null && !this.usuariotipousuarioPK.equals(other.usuariotipousuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.Usuariotipousuario[ usuariotipousuarioPK=" + usuariotipousuarioPK + " ]";
    }

}
