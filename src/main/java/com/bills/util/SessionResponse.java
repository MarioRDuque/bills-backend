package com.bills.util;

import com.bills.dto.SessionItemDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends Respuesta {

    private SessionItemDTO item;
}
