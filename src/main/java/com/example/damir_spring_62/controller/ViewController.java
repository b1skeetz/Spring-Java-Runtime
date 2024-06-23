package com.example.damir_spring_62.controller;

import com.example.damir_spring_62.pojos.Categories;
import com.example.damir_spring_62.pojos.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/view_controller")
public class ViewController
{
    @GetMapping(path="/view_page_1")
    public String viewPage1(Model model){
        String message = "Message from ViewController.viewPage1()";
        model.addAttribute("message", message);
        return "view_page_1";
    }

    @GetMapping(path = "/view_page_2")
    public String viewPage2(Model model){
        Product product = new Product("IPhone 15 Pro Max", 1500000, Categories.SMARTPHONES.name());
        model.addAttribute("product", product);
        return "view_page_2";
    }
}
