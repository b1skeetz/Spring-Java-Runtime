package com.example.damir_spring_62.services;

import com.example.damir_spring_62.pojos.Categories;
import com.example.damir_spring_62.pojos.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class ProductBean {
    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product("Xiaomi 13", 320000, Categories.SMARTPHONES.name()),
                    new Product("Bloody S98 Naraka", 35000, Categories.KEYBOARDS.name()),
                    new Product("Asus ROG Strix G713", 600000, Categories.LAPTOPS.name()),
                    new Product("AirPods 3", 120000, Categories.HEADPHONES.name()),
                    new Product("Lenovo Legion 5", 430000, Categories.LAPTOPS.name()),
                    new Product("Samsung Galaxy S24 Ultra", 800000, Categories.SMARTPHONES.name())
            ));

    public boolean addProduct(String name, Integer price, String category) {
        if (name == null || price == null || category == null) {
            return false;
        }
        Product temp = new Product(name, price, category);
        products.add(temp);
        return true;
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public List<Product> getProductByCategoryName(String categoryName){
        if(categoryName == null){
            return null;
        }
        return products.stream().filter(p -> p.getCategory().equals(categoryName)).collect(Collectors.toList());
    }

}
