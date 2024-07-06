package com.example.damir_spring_62.repository;

import com.example.damir_spring_62.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
