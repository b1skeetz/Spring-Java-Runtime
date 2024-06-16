package com.example.damir_spring_62.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping(path="/home")
public class HomeController {

    @GetMapping(value = "/page", produces = "text/html")
    public String homePage(){
        return "";
    }
}