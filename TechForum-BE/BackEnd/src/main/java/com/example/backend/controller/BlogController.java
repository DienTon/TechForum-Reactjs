package com.example.backend.controller;

import com.example.backend.model.Blog.Blog;
import com.example.backend.service.BlogService.IBlogService;

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
@CrossOrigin(value = "http://localhost:3000",allowedHeaders = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> showAllBlog(
            @RequestParam(defaultValue = "0") int page
    ) {
        Sort sort = Sort.by("viewBlog").ascending();
        Pageable pageable = PageRequest.of(page, 99, sort);
        Page<Blog> blogs = blogService.findAll(pageable);
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
//    public ResponseEntity<ApiResponseDTO<Void>> createNewLanding(@RequestBody @Valid LandingRequestDTO landingRequestDTO) {
//        iLandingService.createLanding(landingRequestDTO);
//
//        ApiResponseDTO apiResponseDTO = ApiResponseDTO.builder().code(1000).message("Thêm mặt bằng thành công").build();
//
//        return new ResponseEntity<>(apiResponseDTO,HttpStatus.OK);
//    }
    @PostMapping("/addNewBlog")
    public void addNewBlog(@RequestBody @Valid Blog blog){
        blogService.addNewBlog(blog);
    }
}