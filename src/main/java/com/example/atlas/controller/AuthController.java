package com.example.atlas.controller;

import com.example.atlas.model.UserDto;
import com.example.atlas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.atlas.service.UserService.UserAlreadyExistsException;

@Controller
public class AuthController {
    private @Autowired UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        if (model.containsAttribute("userAlreadyExists")) {
            user.setUsername((String) model.getAttribute("username"));
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") UserDto user, RedirectAttributes attributes) {
        try {
            userService.addNewUser(user.getUsername(), user.getPassword());
        } catch (UserAlreadyExistsException e) {
            attributes.addFlashAttribute("userAlreadyExists", true);
            attributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/signup";
        }
        return "redirect:/";
    }

}
