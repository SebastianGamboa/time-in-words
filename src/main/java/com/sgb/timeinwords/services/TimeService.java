package com.sgb.timeinwords.services;

import java.io.InputStream;
import java.util.List;

import com.sgb.timeinwords.shared.models.ResponseTimeInWords;

public interface TimeService {
    
    /**
     * Given the time in numerals, convert time to words
     * @param in
     * @return The list of time in words
     */
    public List<ResponseTimeInWords> getTimeInWords(InputStream in);
}
