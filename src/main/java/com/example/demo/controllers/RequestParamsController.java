package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("example")
    public ParamDto getExample(@RequestParam(name = "msg", required = false, defaultValue = "empty") String message) {

        ParamDto param = new ParamDto();
        // param.setMessage(message != null ? message : "default");
        param.setMessage(message);

        return param;
    }

}
