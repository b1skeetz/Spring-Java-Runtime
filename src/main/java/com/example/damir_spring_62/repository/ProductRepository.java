package com.example.damir_spring_62.repository;

import com.example.damir_spring_62.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContains(String name);
    List<Product> findProductsByCategory_NameContains(String name);
}
