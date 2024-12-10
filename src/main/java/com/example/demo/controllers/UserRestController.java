package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.dto.UserDto;

@RestController
@RequestMapping("api")
public class UserRestController {

    @GetMapping("details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("John", "Doe");

        userDto.setTitle("Details template");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("details-map")
    public Map<String, Object> detailsMap() {

        Map<String, Object> body = new HashMap<>();
        User user = new User("John", "Doe");

        body.put("title", "Details template");
        body.put("user", user);
        return body;
    }
}
