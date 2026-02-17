package com.example.ms_llbj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/public")
    public String publico() {
        return "Rota pública";
    }

    @GetMapping("/private")
    public String privado() {
        return "Rota privada";
    }
}
