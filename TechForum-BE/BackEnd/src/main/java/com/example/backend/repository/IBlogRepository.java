package com.example.backend.repository;


import com.example.backend.model.Blog.Blog;
import com.example.backend.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findByStatusFalse();
    List<Blog> findByUser(User user);
    @Query("SELECT b FROM Blog b WHERE b.title LIKE %:title%")
    List<Blog> findByTitle(@Param("title") String title);

}
