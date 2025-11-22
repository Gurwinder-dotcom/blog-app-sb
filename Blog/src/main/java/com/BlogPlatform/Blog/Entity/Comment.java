package com.BlogPlatform.Blog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;
    @Column(name = "text",nullable = false,columnDefinition = "TEXT")
    private String Text;


    //    many comments belong to one blog
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;  //Fk

    //  one user can write many comments
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //Fk
}
