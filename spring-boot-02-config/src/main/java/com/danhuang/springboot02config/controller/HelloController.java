package com.danhuang.springboot02config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.last-name}")
    String name;

    @RequestMapping("hello")
    public String sayHello(){
        return "Hello:"+name;
    }
}
