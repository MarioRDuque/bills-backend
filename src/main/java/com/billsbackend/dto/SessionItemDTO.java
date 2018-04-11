package com.billsbackend.dto;

import com.billsbackend.entidades.Menu;
import java.util.List;
import lombok.*;

@Data
public class SessionItemDTO {

    private String nombrecompleto;
    private String token;
    private String usuarioId;
    private String nombre;
    private List<Menu> menus;
    private Long tipoUsuario;

}
