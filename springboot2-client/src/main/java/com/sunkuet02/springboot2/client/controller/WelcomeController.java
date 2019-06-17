package com.sunkuet02.springboot2.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/hola")
    public String sayHola() {
        return "welcome";
    }
}
