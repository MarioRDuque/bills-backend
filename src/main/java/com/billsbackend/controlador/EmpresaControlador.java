package com.billsbackend.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.billsbackend.entidades.Empresa;
import com.billsbackend.exception.GeneralException;
import com.billsbackend.servicio.EmpresaServicio;
import com.billsbackend.util.BusquedaPaginada;
import com.billsbackend.util.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author dev-out-03
 */
@RestController
@RequestMapping("/empresa")
public class EmpresaControlador extends GenericoControladorImpl<Empresa, Long> implements GenericoControlador<Empresa, Long> {

    private final Logger loggerControlador = LoggerFactory.getLogger(getClass());
    @Autowired
    private EmpresaServicio empresaServicio;

    @Autowired
    public EmpresaControlador(EmpresaServicio empresaServicio) {
        super(empresaServicio, "empresa");
    }

    @GetMapping("/validar/{ruc}")
    public ResponseEntity show(@PathVariable String ruc) throws GeneralException {
        Respuesta resp = new Respuesta();
        try {
            Empresa e = empresaServicio.validar(ruc);
            if (e != null) {
                resp.setEstadoOperacion(Respuesta.EstadoOperacionEnum.EXITO.getValor());
                resp.setOperacionMensaje("");
                resp.setExtraInfo(e);
            } else {
                throw new GeneralException("Empresa no registrada", "No hay datos", loggerControlador);
            }
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            loggerControlador.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Empresa obtenerEntidadBuscar(BusquedaPaginada busquedaPaginada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
