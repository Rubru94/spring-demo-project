package com.example.demo.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.User;

@Controller
public class UserController {

    @GetMapping("details")
    public String details(Model model, Map<String, Object> map) {

        User user = new User("John", "Doe");

        model.addAttribute("title", "Details template");
        model.addAttribute("user", user);
        return "details";
    }
}
