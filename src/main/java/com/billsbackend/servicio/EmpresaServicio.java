package com.billsbackend.servicio;

import com.billsbackend.entidades.Empresa;
import com.billsbackend.exception.GeneralException;

public interface EmpresaServicio extends GenericoServicio<Empresa, Long>{

    public Empresa validar(String ruc) throws GeneralException;
}
