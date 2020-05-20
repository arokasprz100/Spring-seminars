package com.example.testing;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHello() {
        return "World";
    }
}