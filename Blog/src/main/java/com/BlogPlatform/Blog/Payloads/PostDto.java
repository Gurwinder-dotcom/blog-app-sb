package com.BlogPlatform.Blog.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    @NotEmpty(message = "Title must not be empty :)")
    @Size(min = 4, message = "Title must contain more than 4 character. :) ")
    private String title;
    @NotEmpty(message = "Body must not be empty :)")
    private String body;
    @NotEmpty(message = "image must not be empty :)")
    private String imageName;
    private UserDto user;
    private CategoryDto category;
}
