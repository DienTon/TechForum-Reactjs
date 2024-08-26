package com.example.backend.model.Blog;


import com.example.backend.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private int viewBlog;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<CommentBlog> comments;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<LikeBlog> likes;
    @Column(name = "creation_date")
    private String creationDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public String formatDate(){
        LocalDateTime now = LocalDateTime.now();

        // Định dạng theo mẫu cụ thể và in ra chuỗi
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd , HH:mm"));
        return formattedDateTime;
    }

    public Blog() {
         this.creationDate = formatDate();
        this.status = false;

    }

    public List<LikeBlog> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeBlog> likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CommentBlog> getComments() {
        return comments;
    }

    public void setComments(List<CommentBlog> comments) {
        this.comments = comments;
    }



    public int getViewBlog() {
        return viewBlog;
    }

    public void setViewBlog(int viewBlog) {
        this.viewBlog = viewBlog;
    }


}
