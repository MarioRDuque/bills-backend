package com.billsbackend.util;

import com.billsbackend.dto.SessionItemDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends Respuesta {

    private SessionItemDTO item;
}
