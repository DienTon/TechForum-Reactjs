package com.example.backend.service.BlogService;


import com.example.backend.model.Blog.LikeBlog;

import java.util.List;

public interface ILikeBlogService {
    List<LikeBlog> findAllLikes();
    void save(LikeBlog likeBlog);
    void delete(Long id);
    LikeBlog findByUserIdAndBlogId(Long userId, Long blogId);
}
