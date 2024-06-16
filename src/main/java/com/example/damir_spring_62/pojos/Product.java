package com.example.damir_spring_62.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Product {
    private final String name;
    private final Integer price;
    private final String category;
    private Map<String, String> properties; // Производитель, AMD

    public Product(String name, Integer price, String category, Map<String, String> properties) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.properties = properties;
    }
}
