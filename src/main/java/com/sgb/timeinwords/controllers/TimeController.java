package com.sgb.timeinwords.controllers;

import java.io.IOException;
import java.util.List;

import com.sgb.timeinwords.services.TimeService;
import com.sgb.timeinwords.shared.models.ResponseTimeInWords;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TimeController {

    TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }
    
    @PostMapping("time-in-words")
    public List<ResponseTimeInWords> timeInWords(@RequestParam("file") MultipartFile file) throws IOException {
        return timeService.getTimeInWords(file.getInputStream());
    }
}
