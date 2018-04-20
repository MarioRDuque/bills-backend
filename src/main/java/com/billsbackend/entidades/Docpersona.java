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
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "docpersona")
@NamedQueries({
    @NamedQuery(name = "Docpersona.findAll", query = "SELECT d FROM Docpersona d")})
public class Docpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocpersonaPK docpersonaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nrodoc")
    private String nrodoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idtipodocumento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipodocumento tipodocumento;
    @Column(name = "idpersona", insertable = false, updatable = false)
    private Long persona;

    public Docpersona() {
    }

    public Docpersona(DocpersonaPK docpersonaPK) {
        this.docpersonaPK = docpersonaPK;
    }

    public Docpersona(DocpersonaPK docpersonaPK, String nrodoc) {
        this.docpersonaPK = docpersonaPK;
        this.nrodoc = nrodoc;
    }

    public Docpersona(long idpersona, int idtipodocumento) {
        this.docpersonaPK = new DocpersonaPK(idpersona, idtipodocumento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docpersonaPK != null ? docpersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docpersona)) {
            return false;
        }
        Docpersona other = (Docpersona) object;
        if ((this.docpersonaPK == null && other.docpersonaPK != null) || (this.docpersonaPK != null && !this.docpersonaPK.equals(other.docpersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bills.entidades.Docpersona[ docpersonaPK=" + docpersonaPK + " ]";
    }
    
}
