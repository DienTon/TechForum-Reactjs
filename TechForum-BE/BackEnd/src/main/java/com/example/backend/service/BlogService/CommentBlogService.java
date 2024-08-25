package com.example.backend.service.BlogService;

import com.example.backend.model.Blog.CommentBlog;
import com.example.backend.repository.ICommentBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentBlogService implements ICommentBlogService {
    @Autowired
    ICommentBlogRepo commentBlogRepo;

    @Override
    public List<CommentBlog> findAllCommentBlogs() {
        return commentBlogRepo.findAll();
    }

    @Override
    public void save(CommentBlog commentBlog) {
        commentBlogRepo.save(commentBlog);
    }

    @Override
    public void delete(Long id) {
        commentBlogRepo.deleteById(id);
    }
}


