package com.example.backend.repository;

import com.example.backend.model.Blog.LikeBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeBlogRepository extends JpaRepository<LikeBlog,Long> {
    LikeBlog findByUserIdAndBlogId(Long userId, Long blogId);
}
