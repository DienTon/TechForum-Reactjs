package com.example.backend.controller;

import com.example.backend.model.Blog.Blog;
import com.example.backend.model.dto.BlogDTO;
import com.example.backend.service.BlogService.IBlogService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(value = "http://localhost:3000", allowedHeaders = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public Page<BlogDTO> showAllBlog(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
        return blogService.findAll(pageable);
    }


    @PostMapping("/addNewBlog")
    public ResponseEntity<String> addNewBlog(@RequestBody @Valid Blog blog) {
        try {
            blogService.addNewBlog(blog);
            return new ResponseEntity<>("Blog created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create blog", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @DeleteMapping("/deleteBlog/{id}")
//    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
//        try {
//            blogService.delete(id);
//            return new ResponseEntity<>("Blog deleted successfully", HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>("Blog not found", HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to delete blog", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PutMapping("/updateBlog/{id}")
//    public ResponseEntity<String> updateBlog(@PathVariable Long id, @RequestBody @Valid Blog updatedBlog) {
//        try {
//            blogService.updateBlogById(id, updatedBlog);
//            return new ResponseEntity<>("Blog updated successfully", HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>("Blog not found", HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to update blog", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
