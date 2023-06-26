package com.practice.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    @GetMapping("/")
    public String login() {
        return "index";
    }

    @PostMapping("/authenticate")
    public String login2() {
        return "/todo";
    }


}
