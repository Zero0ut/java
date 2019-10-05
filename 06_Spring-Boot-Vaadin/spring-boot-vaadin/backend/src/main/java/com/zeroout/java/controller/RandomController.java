package com.zeroout.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@RestController
public class RandomController {

    @RequestMapping("/random-number")
    public double randomNumber() {
        return generateRandomNumber();
    }

    public double generateRandomNumber() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(Math.random()*100));
    }
}
