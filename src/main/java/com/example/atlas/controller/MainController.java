package com.example.atlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "auth";
    }

    @GetMapping("/signup")
    public String signup() {
        return "auth";
    }

    @GetMapping("/practice")
    public String practice() {
        return "practice";
    }

}
