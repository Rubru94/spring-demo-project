package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/", "home" })
    public String home() {
        return "redirect:/list"; // redirect --> change url, resend request & refresh browser
    }

    /*
     * 
     * @GetMapping({ "", "/", "home" })
     * public String home() {
     * return "forward:/list"; // forward --> http request & url do not change, not
     * refresh browser
     * }
     */
}