package com.example.atlas.controller;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.model.Region;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class PracticeController {
    private @Autowired PracticeService practiceService;

    @GetMapping("/practice")
    public String practice(@RequestParam String region, Model model, Principal principal) {
        List<PracticeItem> practiceItems = practiceService.getPracticeByRegion(principal.getName(), region);
        Region regionData = practiceService.getRegionById(region);
        model.addAttribute("practiceItems", practiceItems);
        model.addAttribute("region", regionData);
        return "practice";
    }

    @ResponseBody
    @PostMapping("/practice/item/increment/{id}")
    public void increaseMemoryStrength(@PathVariable Long id, Principal principal) {
        practiceService.increaseMemoryStrength(id, principal.getName());
    }

    @ResponseBody
    @PostMapping("/practice/item/reset/{id}")
    public void resetMemoryStrength(@PathVariable Long id, Principal principal) {
        practiceService.resetMemoryStrength(id, principal.getName());
    }

    @ResponseBody
    @PostMapping("/practice/item/add")
    public void addPracticeItem(@RequestParam String country, @RequestParam String region, Principal principal) {
        practiceService.addPracticeItem(principal.getName(), country, region);
    }

}
