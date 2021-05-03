package com.sgb.timeinwords.shared.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sebastián Gamboa
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseError {
    
    private int status;
    private String message;
}
