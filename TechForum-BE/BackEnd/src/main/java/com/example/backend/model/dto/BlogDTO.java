package com.example.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BlogDTO implements Validator {
    @NotBlank(message = "Not empty")
    @Size(min = 3, message = ">3 characters")
    private String title;

    @Size(min = 3, message = ">3 characters")
    private String content;
    private Long category;
    private Long user;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    private int viewBlog;

    public BlogDTO() {
    }


    public int getViewBlog() {
        return viewBlog;
    }

    public void setViewBlog(int viewBlog) {
        this.viewBlog = viewBlog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
