package com.Todo.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

    @GetMapping("/vue")
    public String test(){
        return "vue/index";
    }
}
