package com.example.ms_llbj.service;

import com.example.ms_llbj.port.HelloInputPort;

@org.springframework.stereotype.Service
public class Service implements HelloInputPort {

    public String helloWorlGet() {
        return "Hello World!";
    }
    public String helloWorldPost() {
        return "Hello World!";
    }
}
