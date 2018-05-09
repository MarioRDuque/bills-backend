
package com.billsbackend.servicio;
import com.billsbackend.entidades.Persona;
import com.billsbackend.exception.GeneralException;

/**
 *
 * @author PCQUISPE
 */
public interface PersonaServicio extends GenericoServicio<Persona, Long>{
  
    public Persona validar(String nombre) throws GeneralException;
}

