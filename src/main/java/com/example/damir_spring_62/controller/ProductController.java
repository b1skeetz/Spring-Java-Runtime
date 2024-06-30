package com.example.damir_spring_62.controller;

import com.example.damir_spring_62.pojos.Product;
import com.example.damir_spring_62.services.ProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/products_task")
public class ProductController {
    private final ProductBean productBean;

    @Autowired
    public ProductController(ProductBean productBean) {
        this.productBean = productBean;
    }

    @GetMapping(path = "/list", produces = "application/json")
    public List<Product> getAll(@RequestParam(name = "categoryName", required = false) String categoryName) {
        if (categoryName != null) {
            return productBean.getProductByCategoryName(categoryName);
        }
        return productBean.getAllProducts();
    }

    @GetMapping(path = "/add", produces = "application/json")
    public Object addProduct(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "price", required = false) Integer price,
            @RequestParam(name = "category", required = false) String categoryName) {
        boolean result = productBean.addProduct(name, price, categoryName);
        if (result) {
            return getAll(null);
        }
        return "Не хватает полей для нового товара!";
    }

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        String category = "";
        model.addAttribute("products", productBean.getProducts());
        return "view_page_1";
    }

    @GetMapping(path = "/products/filter")
    public String filter(@RequestParam(name = "category") String categoryName, Model model){
        List<Product> temp = productBean.getAllProducts().stream()
                .filter(product -> product.getCategory().contains(categoryName)).toList();
        model.addAttribute("products", temp);
        model.addAttribute("category", categoryName);
        return "view_page_1";
    }

}
