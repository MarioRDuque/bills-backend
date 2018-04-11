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
@Table(name = "tipousuariomenuopcion")
@NamedQueries({
    @NamedQuery(name = "Tipousuariomenuopcion.findAll", query = "SELECT t FROM Tipousuariomenuopcion t")})
public class Tipousuariomenuopcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipousuariomenuopcionPK tipousuariomenuopcionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idmenuopcion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menuopcion menuopcion;
    @JoinColumn(name = "idtipousuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipousuario tipousuario;

    public Tipousuariomenuopcion() {
    }

    public Tipousuariomenuopcion(TipousuariomenuopcionPK tipousuariomenuopcionPK) {
        this.tipousuariomenuopcionPK = tipousuariomenuopcionPK;
    }

    public Tipousuariomenuopcion(TipousuariomenuopcionPK tipousuariomenuopcionPK, boolean estado) {
        this.tipousuariomenuopcionPK = tipousuariomenuopcionPK;
        this.estado = estado;
    }

    public Tipousuariomenuopcion(long idtipousuario, long idmenuopcion) {
        this.tipousuariomenuopcionPK = new TipousuariomenuopcionPK(idtipousuario, idmenuopcion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipousuariomenuopcionPK != null ? tipousuariomenuopcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuariomenuopcion)) {
            return false;
        }
        Tipousuariomenuopcion other = (Tipousuariomenuopcion) object;
        if ((this.tipousuariomenuopcionPK == null && other.tipousuariomenuopcionPK != null) || (this.tipousuariomenuopcionPK != null && !this.tipousuariomenuopcionPK.equals(other.tipousuariomenuopcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.Tipousuariomenuopcion[ tipousuariomenuopcionPK=" + tipousuariomenuopcionPK + " ]";
    }
    
}
