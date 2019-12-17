package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping
    @ResponseBody
    public String getHello(){
        return "Hello java190805!!";
    }
}
