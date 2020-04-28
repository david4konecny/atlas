package com.example.atlas.controller;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/summary")
    public String summary(@RequestParam String region, Model model) {
        List<PracticeItem> practiceItems = practiceService.getItemsByRegionSortedByNextReview(region);
        model.addAttribute("practiceItems", practiceItems);
        return "summary";
    }

    @GetMapping("/practice")
    public String practice(@RequestParam String region, Model model) {
        List<PracticeItem> practiceItems = practiceService.getPracticeByRegion(region);
        String[] countriesInRegion = practiceService.getCountriesInRegion(region);
        model.addAttribute("practiceItems", practiceItems);
        model.addAttribute("countriesInRegion", countriesInRegion);
        return "practice";
    }

    @ResponseBody
    @PutMapping("/practice/item/increase/{id}")
    public void increaseMemoryStrength(@PathVariable Long id) {
        practiceService.increaseMemoryStrength(id);
    }

    @ResponseBody
    @PutMapping("/practice/item/reset/{id}")
    public void resetMemoryStrength(@PathVariable Long id) {
        practiceService.resetMemoryStrength(id);
    }

    @ResponseBody
    @PostMapping("/practice/item/add")
    public void addPracticeItem(@RequestParam String country, @RequestParam String region) {
        practiceService.addPracticeItem(country, region);
    }

}
