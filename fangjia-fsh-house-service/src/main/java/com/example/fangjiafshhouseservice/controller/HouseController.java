package com.example.fangjiafshhouseservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author lijin
 * @Date 2019/7/1 16:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/house")
public class HouseController {

    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }

}
