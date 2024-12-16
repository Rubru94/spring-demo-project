package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    /**
     * @example request GET using annotation @RequestParam
     */
    @GetMapping("example")
    public ParamDto getExample(@RequestParam(name = "msg", required = false, defaultValue = "empty") String message) {

        ParamDto paramDto = new ParamDto();
        // param.setMessage(message != null ? message : "default");
        paramDto.setMessage(message);
        return paramDto;
    }

    /**
     * @example request GET using annotation @RequestParam with several request
     *          params
     */
    @GetMapping("several-reqparams")
    public ParamDto getSeveralReqParams(@RequestParam String text, @RequestParam Integer code) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }

    /**
     * @example request GET using HttpServletRequest
     */
    @GetMapping("servlet-request")
    public ParamDto getParamUsingServletRequest(HttpServletRequest request) {

        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (Exception e) {
        }

        ParamDto paramDto = new ParamDto();
        paramDto.setCode(code);
        paramDto.setMessage(request.getParameter("text"));
        return paramDto;
    }

}
