package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.ParamDto;

@RestController
@RequestMapping("api/path-var")
public class PathVariableController {

    /**
     * @example request GET using annotation @PathVariable
     */
    @GetMapping("example/{msg}")
    public ParamDto getExample(@PathVariable(name = "msg") String message) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

}
