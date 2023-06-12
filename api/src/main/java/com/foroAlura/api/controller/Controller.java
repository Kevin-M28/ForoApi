package com.foroAlura.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
public class Controller {
    @GetMapping
    public String hello(){
        return "Hello World";
    }

}
