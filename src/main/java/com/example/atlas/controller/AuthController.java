package com.example.atlas.controller;

import com.example.atlas.exception.UserAlreadyExistsException;
import com.example.atlas.model.UserDto;
import com.example.atlas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;

@Controller
public class AuthController {
    private @Autowired UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/account")
    public String account() {
        return "account";
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
    public String processRegistration(Model model, RedirectAttributes attributes,
                                      @ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult,
                                      HttpServletRequest request) throws ServletException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "signup";
        }
        try {
            userService.addNewUser(user.getUsername(), user.getPassword());
        } catch (UserAlreadyExistsException e) {
            attributes.addFlashAttribute("userAlreadyExists", true);
            attributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/signup";
        }
        request.login(user.getUsername(), user.getPassword());
        return "redirect:/dashboard";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(HttpServletRequest req, Principal principal) throws ServletException {
        userService.deleteUser(principal.getName());
        req.logout();
        return "redirect:/";
    }

}
