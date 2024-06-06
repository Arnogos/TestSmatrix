package com.example.demo.controller;

import com.example.demo.enity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelComeController {

    @GetMapping("/welcome")
    public String greeting() {
        return "welcome";
    }
}