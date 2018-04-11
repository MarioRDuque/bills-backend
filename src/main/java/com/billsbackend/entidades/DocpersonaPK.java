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

@Data
@Embeddable
public class DocpersonaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersona")
    private long idpersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipodocumento")
    private int idtipodocumento;

    public DocpersonaPK() {
    }

    public DocpersonaPK(long idpersona, int idtipodocumento) {
        this.idpersona = idpersona;
        this.idtipodocumento = idtipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpersona;
        hash += (int) idtipodocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocpersonaPK)) {
            return false;
        }
        DocpersonaPK other = (DocpersonaPK) object;
        if (this.idpersona != other.idpersona) {
            return false;
        }
        if (this.idtipodocumento != other.idtipodocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.DocpersonaPK[ idpersona=" + idpersona + ", idtipodocumento=" + idtipodocumento + " ]";
    }

}
