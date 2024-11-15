package com.example.backend.service.BlogService;


import com.example.backend.model.Blog.Blog;
import com.example.backend.model.dto.BlogDTO;
import com.example.backend.model.user.User;
import com.example.backend.repository.IBlogRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Blog updateBlog(Long id,@Valid BlogDTO updatedBlog) {
        if (iBlogRepository.existsById(id)) {
            Blog blog = iBlogRepository.findById(id).get();
            blog.setViewBlog(updatedBlog.getViewBlog());
            blog.setCategory(updatedBlog.getCategory());
            blog.setUser(updatedBlog.getUser());
            blog.setContent(updatedBlog.getContent());
            blog.setTitle(updatedBlog.getTitle());
            blog.setStatus(updatedBlog.getStatus());
            return iBlogRepository.save(blog);
        } else {
            throw new EntityNotFoundException("Blog with id " + id + " not found");
        }
    }

    @Override
    public List<Blog> findByUser(User user) {
        return iBlogRepository.findByUser(user);
    }

    @Override
    public Page<BlogDTO> findAll(Pageable pageable) {
        Page<Blog>blogs =iBlogRepository.findAll(pageable);
        return  blogs.map(blog -> new BlogDTO(blog));
    }

    @Override
    public Blog addNewBlog(BlogDTO blog) {
       return iBlogRepository.save(dtoToObject(blog));
    }

    @Override
    public List<Blog> findAlll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findOne(long id) {
       return iBlogRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        Blog blog = iBlogRepository.findById(id).get();
        blog.setStatus(true);
        iBlogRepository.save(blog);
    }


    @Override
    public List<Blog> findByTitle(String title) {
        return iBlogRepository.findByTitle(title);

    }
    public Blog dtoToObject(BlogDTO blogDTO){
        return new Blog(blogDTO);
    }

    @Override
    public List<Blog> findByStatusFalse () {
        return iBlogRepository.findByStatusFalse();
    }
}
