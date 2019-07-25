package com.jin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Value("${server.port}")
    private  String port;


    @GetMapping("/hello")
    public String hello() {
        return "I am provider->"+port;
    }

}
