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

import com.example.demo.models.CustomConfigProperties;
import com.example.demo.models.User;
import com.example.demo.models.dto.UserDto;

@RestController
@RequestMapping("api")
public class UserRestController {

    private final CustomConfigProperties customConfigProperties;

    public UserRestController(CustomConfigProperties customConfigProperties) {
        this.customConfigProperties = customConfigProperties;
    }

    @Value("${custom.config.cod}")
    private Long cod;

    @Value("${custom.config.username}")
    private String username;

    @Value("${custom.config.valuesList}")
    private List<String> valuesList;

    /*
     * Spring Expression Language (SpEL) is a powerful expression language that
     * supports querying and manipulating an object graph at runtime
     */
    @Value("#{'${custom.config.valuesList}'.split(',')}")
    private List<String> valuesListSpEL;

    @Value("#{'${custom.config.valuesList}'.toUpperCase()}")
    private String valuesStringSpEL;

    /*
     * @INFO config
     * 
     * SpEL sintax for objects/maps working directly only with .properties files
     */
    /*
     * @Value("#{${custom.config.valuesMap}}")
     * private Map<String, Object> valuesMap;
     */

    /*
     * @INFO config
     * 
     * For config .yaml files we can obtain values from objects/maps using a
     * Configuration class
     */
    public Map<String, Object> getValuesMap() {
        return customConfigProperties.getValuesMap();
    }

    /*
     * @Value("#{${custom.config.valuesMap}.product}")
     * private String product;
     */

    /*
     * @Value("#{${custom.config.valuesMap}.price}")
     * private Long price;
     */

    @GetMapping("values")
    public Map<String, Object> values(@Value("${custom.config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("cod", cod);
        json.put("username", username);
        json.put("valuesList", valuesList);
        json.put("valuesListSpEL", valuesListSpEL);
        json.put("valuesStringSpEL", valuesStringSpEL);
        json.put("valuesMap", /* valuesMap */ getValuesMap());
        json.put("product", /* product */ getValuesMap().get("product"));
        json.put("price", /* price */ getValuesMap().get("price"));
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
