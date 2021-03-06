/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.billsbackend.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Size(min = 1, max = 6)
    @Column(name = "codigoadmin", insertable = false, updatable = false)
    private String codigoadmin;
    @JoinColumn(name = "idubigeo", referencedColumnName ="id")
    @ManyToOne(optional = true)
    private Ubigeo idubigeo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacaducidad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = true)
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @JoinColumn(name = "idregimen", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Regimen idregimen;

    public Empresa() {
    }

    public Empresa(String ruc) {
        this.ruc = ruc;
    }

    public Empresa(String ruc, String razonsocial, Ubigeo idubigeo, byte[] logo, Date fechacaducidad, boolean estado) {
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.idubigeo = idubigeo;
        this.logo = logo;
        this.fechacaducidad = fechacaducidad;
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        return !((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc)));
    }

    @Override
    public String toString() {
        return "com.bills.entidades.Empresa[ ruc=" + ruc + " ]";
    }

}
