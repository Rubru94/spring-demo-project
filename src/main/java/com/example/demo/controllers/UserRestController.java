package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserRestController {

    @GetMapping("details")
    public Map<String, Object> details() {

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Details template");
        body.put("name", "John");
        body.put("lastname", "Doe");
        return body;
    }
}
