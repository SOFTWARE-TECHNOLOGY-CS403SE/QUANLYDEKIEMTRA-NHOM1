package com.example.thionline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    private String login(){

        System.err.println("login page...");

        return "/index";
    }

}
