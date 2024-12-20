package com.example.demo.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.dto.UserDto;

@RestController
@RequestMapping("api")
public class UserRestController {

    @Value("${custom.config.cod}")
    private Long cod;

    @Value("${custom.config.username}")
    private String username;

    @Value("${custom.config.valuesList}")
    private Integer[] valuesList;

    @GetMapping("values")
    public Map<String, Object> values(@Value("${custom.config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("cod", cod);
        json.put("username", username);
        json.put("valuesList", valuesList);
        json.put("message", message);
        return json;
    }

    @GetMapping("details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("John", "Doe");

        userDto.setTitle("Details template");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("details-list")
    public List<User> list() {
        User user = new User("John", "Doe");
        User user2 = new User("Arthur", "Morgan");
        User user3 = new User("Elver", "Galarga");

        /*
         * List<User> users = new ArrayList<>();
         * users.add(user);
         * users.add(user2);
         * users.add(user3);
         */

        // same result --> Arrays.asList
        List<User> users = Arrays.asList(user, user2, user3);

        return users;
    }

    @GetMapping("details-map")
    public Map<String, Object> detailsMap() {

        Map<String, Object> body = new HashMap<>();
        User user = new User("John", "Doe");

        body.put("title", "Details template");
        body.put("user", user);
        return body;
    }

    @PostMapping()
    public User create(@RequestBody User entity) {
        // TODO: process POST request, e.g. like saving user or convert to upper case
        if (entity.getLastname() != null)
            entity.setLastname(entity.getLastname().toUpperCase());
        return entity;
    }

}
