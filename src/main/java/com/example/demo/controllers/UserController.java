package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

        model.addAttribute("title", "List template");

        return "list";
    }

    /*
     * @ModelAttribute
     * 
     * Annotation that binds a method parameter or method return value to a named
     * model attribute, exposed to a web view.
     */
    @ModelAttribute("users")
    public List<User> getUsersModel() {
        return Arrays.asList(
                new User("John", "Doe", "jd@gmail.com"),
                new User("Arthur", "Morgan"),
                new User("Elver", "Galarga", "elga@hotmail.com"));
    }
}
