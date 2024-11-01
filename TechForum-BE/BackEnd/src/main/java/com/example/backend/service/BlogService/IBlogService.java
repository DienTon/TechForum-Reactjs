package com.example.backend.service.BlogService;

import com.example.backend.model.Blog.Blog;
import com.example.backend.model.dto.BlogDTO;
import com.example.backend.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog updateBlog(Long id, Blog updatedBlog);
    List<Blog> findByUser(User user);
    Page<BlogDTO>findAll(Pageable pageable);
    void addNewBlog(Blog blog);
    List<Blog> findAlll();
    Blog findOne(long id);
    void delete(long id);
    void save(Blog blog);
    List<Blog> findByTitle(String title);
    List<Blog> findByStatusFalse();
}
