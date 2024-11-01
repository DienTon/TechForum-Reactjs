package com.example.backend.service.BlogService;


import com.example.backend.model.Blog.Blog;
import com.example.backend.model.dto.BlogDTO;
import com.example.backend.model.user.User;
import com.example.backend.repository.IBlogRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public Blog updateBlog(Long id, Blog updatedBlog) {
        if (iBlogRepository.existsById(id)) {
            updatedBlog.setId(id); // Đảm bảo rằng đối tượng có id đúng
            return iBlogRepository.save(updatedBlog);
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
    public void addNewBlog(Blog blog) {
        iBlogRepository.save(blog);
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
        iBlogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return iBlogRepository.findByTitle(title);

    }


    @Override
    public List<Blog> findByStatusFalse () {
        return iBlogRepository.findByStatusFalse();
    }
}
