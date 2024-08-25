package com.example.backend.service.CategoryService;



import com.example.backend.model.Blog.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> finAll();
    Category findByName(String name);
    Category findById(Long id);
}
