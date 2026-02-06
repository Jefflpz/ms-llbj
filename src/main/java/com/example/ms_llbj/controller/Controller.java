package com.example.ms_llbj.controller;
import com.example.ms_llbj.port.HelloInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class Controller {

    @Autowired
    private HelloInputPort port;
    @GetMapping
    public String HellowWorld() {
        // usa o atributo instãnciado do serviço para chamar o método helloWorld que está na classe HelloWorldService
        return port.helloWorlGet();
    }
}
