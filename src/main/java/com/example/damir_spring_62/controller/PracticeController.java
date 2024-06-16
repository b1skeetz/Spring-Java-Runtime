package com.example.damir_spring_62.controller;

import com.example.damir_spring_62.pojos.Categories;
import com.example.damir_spring_62.pojos.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "/practice_controller")
public class PracticeController {

    private Map<String, String> properties = new HashMap<>();

    private Product[] products = new Product[]{
            new Product("Xiaomi 13", 320000, Categories.SMARTPHONES.name(), Map.of("ОЗУ", "12 Гб", "Память", "256 Гб")),
            new Product("Bloody S98 Naraka", 35000, Categories.KEYBOARDS.name(), Map.of("Размер", "90%", "Цвет", "Красный")),
            new Product("Asus ROG Strix G713", 600000, Categories.LAPTOPS.name(), Map.of("Процессор", "AMD Ryzen 7", "Видеокарта", "RTX 3060")),
            new Product("AirPods 3", 120000, Categories.HEADPHONES.name(), Map.of("Цвет", "Серый", "Вес", "100 г")),
            new Product("Lenovo Legion 5", 430000, Categories.LAPTOPS.name(), Map.of("Процессор", "Intel Core I5", "Видеокарта", "RTX 2060")),
            new Product("Samsung Galaxy S24 Ultra", 800000, Categories.SMARTPHONES.name(), Map.of("ОЗУ", "16 Гб", "Память", "512 Гб")),
    };

    @GetMapping(path = "/practice_page_1", produces = "application/json")
    public Object showProducts(
            @RequestParam(name = "categoryName", required = false) String categoryName
    ) {
        if (categoryName != null) {
            List<Product> temp = new ArrayList<>();
            for (Product product : products) {
                if (product.getCategory().equals(categoryName)) {
                    temp.add(product);
                }
            }
            return temp;
        }
        return products;
    }

    @GetMapping(path = "/practice_page_2", produces = "application/json")
    public Object fromTo(
            @RequestParam(name = "from", required = false) Integer from,
            @RequestParam(name = "to", required = false) Integer to,
            @RequestParam(name = "categoryName", required = false) String categoryName
    ) {
        List<Product> temp = new ArrayList<>();
        if (to == null) {
            to = Integer.MAX_VALUE;
        }
        if (from == null) {
            from = Integer.MIN_VALUE;
        }

        for (Product product : products) {
            if (categoryName != null) {
                if (product.getPrice() >= from && product.getPrice() <= to && product.getCategory().equals(categoryName)) {
                    temp.add(product);
                }
            } else {
                if (product.getPrice() >= from && product.getPrice() <= to) {
                    temp.add(product);
                }
            }
        }
        return temp;
    }

    // 1 -> 0, 1
    // 2 -> 2, 3
    // 3 -> 4, 5
    // 4 -> 6, 7
    // 5 -> 8, 9

    @GetMapping(path = "/practice_page_3")
    public Object getProductsViaPages(@RequestParam(name = "page", required = false) Integer page) {
        if (page != null) {
            List<Product> temp = new ArrayList<>();
            temp.add(products[(page - 1) * 2]);
            temp.add(products[(page - 1) * 2 + 1]);
            return temp;
        }
        return products;
    }

    @GetMapping(path = "/filter", produces = "application/json")
    public Object filter(@RequestParam(name = "property", required = false) String property,
                         @RequestParam(name = "value", required = false) String value){
        if(property != null && value != null){
           return Arrays.stream(products).filter(p ->
                   p.getProperties().containsKey(property) && p.getProperties().get(property).equals(value))
                   .findFirst().orElse(null);
        }
        return new Object();
    }
}
