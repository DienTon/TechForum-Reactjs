package com.example.backend.repository;

import com.example.backend.model.Blog.CommentBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentBlogRepo extends JpaRepository<CommentBlog, Long> {
}
