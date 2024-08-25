package com.example.backend.service.BlogService;


import com.example.backend.model.Blog.CommentBlog;

import java.util.List;

public interface ICommentBlogService {
    List<CommentBlog> findAllCommentBlogs();
    void save(CommentBlog commentBlog);
    void delete(Long id);
}
