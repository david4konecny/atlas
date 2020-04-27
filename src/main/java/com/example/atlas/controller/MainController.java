package com.example.atlas.controller;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PracticeService practiceService;

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
    public String practice(@RequestParam String region, Model model) {
        List<PracticeItem> practiceItems = practiceService.getPracticeByRegion(region);
        model.addAttribute("practiceItems", practiceItems);
        return "practice";
    }

}
