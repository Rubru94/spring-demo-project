package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.User;

@Controller
public class UserController {

    @GetMapping("details")
    public String details(Model model, Map<String, Object> map) {

        User user = new User("John", "Doe");
        user.setEmail("example@example.com");

        model.addAttribute("title", "Details template");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("list")
    public String list(ModelMap model) {
        User user1 = new User("John", "Doe", "jd@gmail.com");
        User user2 = new User("Arthur", "Morgan");
        User user3 = new User("Elver", "Galarga", "elga@hotmail.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        model.addAttribute("title", "List template");
        model.addAttribute("users", users);

        return "list";
    }
}
