package com.sgb.timeinwords.shared.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseTimeInWords {
    
    private int hora;
    private int minutos;
    private String resultado;
}
