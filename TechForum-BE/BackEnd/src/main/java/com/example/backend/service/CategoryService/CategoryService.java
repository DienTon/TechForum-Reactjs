package com.example.backend.service.CategoryService;


import com.example.backend.model.Blog.Category;
import com.example.backend.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> finAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        return iCategoryRepository.findByName(name);
    }


    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }
}
