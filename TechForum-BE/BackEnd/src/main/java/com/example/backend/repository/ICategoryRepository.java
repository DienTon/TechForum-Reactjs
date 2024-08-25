package com.example.backend.repository;


import com.example.backend.model.Blog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Category findOneByName(String name);
    Category findByName(String name);
}