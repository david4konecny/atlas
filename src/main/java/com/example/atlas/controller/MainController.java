package com.example.atlas.controller;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.model.Region;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
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
    public String dashboard(Model model) {
        Collection<Region> regions = practiceService.getAllRegions();
        model.addAttribute("regions", regions);
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
    public String summary(@RequestParam String region, Model model, Principal principal) {
        List<PracticeItem> practiceItems = practiceService.getItemsByRegionSortedByNextReview(region, principal.getName());
        model.addAttribute("practiceItems", practiceItems);
        return "summary";
    }

    @GetMapping("/practice")
    public String practice(@RequestParam String region, Model model, Principal principal) {
        List<PracticeItem> practiceItems = practiceService.getPracticeByRegion(principal.getName(), region);
        // String[] countriesInRegion = practiceService.getCountriesInRegion(region);
        Region regionData = practiceService.getRegionByName(region);
        model.addAttribute("practiceItems", practiceItems);
        model.addAttribute("region", regionData);
        // model.addAttribute("countriesInRegion", countriesInRegion);
        return "practice";
    }

    @ResponseBody
    @PostMapping("/practice/item/increment/{id}")
    public void increaseMemoryStrength(@PathVariable Long id) {
        practiceService.increaseMemoryStrength(id);
    }

    @ResponseBody
    @PostMapping("/practice/item/reset/{id}")
    public void resetMemoryStrength(@PathVariable Long id) {
        practiceService.resetMemoryStrength(id);
    }

    @ResponseBody
    @PostMapping("/practice/item/add")
    public void addPracticeItem(@RequestParam String country, @RequestParam String region, Principal principal) {
        practiceService.addPracticeItem(principal.getName(), country, region);
    }

}
