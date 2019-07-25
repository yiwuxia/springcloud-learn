package com.jin.controller;

import com.jin.domain.HouseInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Value("${server.port}")
    private  String port;


    @GetMapping("/hello")
    public String hello() {
        return "I am provider->"+port;
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return new HouseInfo(1L, "上海", "虹口", "东体小区");
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return name;
    }

    @PostMapping("/save")
    public Long addData(@RequestBody HouseInfo info){
        System.out.println(info);
        return  100L;
    }


}
