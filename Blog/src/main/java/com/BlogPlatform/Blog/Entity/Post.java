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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT",length = 1000)
    private String body;

    private String imageName;
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //    one Blog belong to one user  --> one to one
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //FK


    //    one Blog has many comments  --> one to many
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
