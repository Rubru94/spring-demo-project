package com.example.demo.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("details")
    public String details(Model model, Map<String, Object> map) {

        model.addAttribute("title", "Details template");
        model.addAttribute("name", "John");
        // model.addAttribute("lastname", "Doe");
        map.put("lastname", "Does");
        return "details";
    }
}
