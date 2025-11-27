package com.BlogPlatform.Blog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;


    //    one Blog belong to one user  --> one to one
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //FK


    //    one Blog has many comments  --> one to many
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @PrePersist
    protected void createdOn() {
        createdAt = LocalDateTime.now();
    }
}
