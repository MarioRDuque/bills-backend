/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "confempresa")
@NamedQueries({
    @NamedQuery(name = "Confempresa.findAll", query = "SELECT c FROM Confempresa c")})
public class Confempresa implements Serializable {
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdecimal")
    private int pdecimal;
    @JoinColumn(name = "ruc", referencedColumnName = "ruc", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empresa empresa;

    public Confempresa() {
    }

    public Confempresa(String ruc) {
        this.ruc = ruc;
    }

    public Confempresa(String ruc, boolean estado, int pdecimal) {
        this.ruc = ruc;
        this.estado = estado;
        this.pdecimal = pdecimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Confempresa)) {
            return false;
        }
        Confempresa other = (Confempresa) object;
        return !((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc)));
    }

    @Override
    public String toString() {
        return "com.billsbackend.entidades.Confempresa[ ruc=" + ruc + " ]";
    }

}
