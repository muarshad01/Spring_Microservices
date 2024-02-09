package com.in28minutes.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.RestController;
import com.in28minutes.microservices.limitsservice.bean.Limits;
import com.in28minutes.microservices.limitsservice.configuration.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimists() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
