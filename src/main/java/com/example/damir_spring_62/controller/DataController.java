package com.example.damir_spring_62.controller;

import com.example.damir_spring_62.entity.Product;
import com.example.damir_spring_62.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/data")
public class DataController {
    private final ProductRepository productRepository;

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "view_page_1";
    }

    @GetMapping(path = "/products/filter")
    public String filter(@RequestParam(name = "categoryName", required = false) String categoryName, Model model){
        List<Product> temp = productRepository.findProductsByCategory_NameContains(categoryName);
        if(temp.isEmpty()){
            return getProducts(model);
        }
        model.addAttribute("products", temp);
        model.addAttribute("category", categoryName);

        return "view_page_1";
    }
}
