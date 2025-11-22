package com.BlogPlatform.Blog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "about",columnDefinition = "TEXT")
    private String about;


    //    one User can write many blog
    @OneToMany(mappedBy = "user")
    private List<Post> postList;


    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}