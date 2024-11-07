package com.example.backend.model.dto;

import com.example.backend.model.Blog.Blog;
import com.example.backend.model.Blog.Category;
import com.example.backend.model.user.User;
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
    private Category category;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private int viewBlog;
    private Boolean status;

    public BlogDTO(Blog blog) {
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.category = blog.getCategory();
        this.user = blog.getUser();
        this.viewBlog = blog.getViewBlog();
        this.status = blog.getStatus();
    }

    public BlogDTO() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
