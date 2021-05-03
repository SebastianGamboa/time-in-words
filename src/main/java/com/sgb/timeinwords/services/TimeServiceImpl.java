package com.sgb.timeinwords.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sgb.timeinwords.shared.models.ResponseTimeInWords;

import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    private final String numberInWords[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine" };

    @Override
    public List<ResponseTimeInWords> getTimeInWords(InputStream in) {
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
            .lines()
            .map(this::handleLine)
            .collect(Collectors.toList());
    }

    private ResponseTimeInWords handleLine(String line) {
        var divTime = separateTime(line);
        var hour = divTime[0];
        var minutes = divTime[1];
        var timeInWords = convertTimeToWords(hour, minutes);
        return new ResponseTimeInWords(hour, minutes, timeInWords);
    }

    private int[] separateTime(String time) throws NumberFormatException {
        return Arrays.stream(time.split(":")).mapToInt(Integer::valueOf).toArray();
    }

    private String convertTimeToWords(int hour, int minutes) {
        String timeInWords = "";
        if ((hour >= 1 && hour <= 12) && (minutes >= 0 && minutes <= 59)) {
            String hourInWord = hour == 12 ? numberInWords[1] : numberInWords[hour + 1];
            if (minutes == 0)
                timeInWords = numberInWords[hour] + " o'clock";
            else if (minutes == 15)
                timeInWords = "Quarter past " + numberInWords[hour];
            else if (minutes == 30)
                timeInWords = "Half past " + numberInWords[hour];
            else if (minutes == 45)
                timeInWords = "Quarter to " + hourInWord;
            else if (minutes < 30)
                timeInWords = numberInWords[minutes] + " past " + numberInWords[hour];
            else
                timeInWords = numberInWords[60 - minutes] + " to " + hourInWord;
        } else {
            throw new RuntimeException("Time ranges must be: 1 <= Hour <= 12, 0 <= Minutes < 60");
        }
        return timeInWords;
    }
}
