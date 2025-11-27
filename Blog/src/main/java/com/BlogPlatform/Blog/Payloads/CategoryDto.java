package com.BlogPlatform.Blog.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    @NotEmpty(message = "Title must not be  Empty. :) ")
    @Size(min = 4, message = "Title must contain more than 4 character. :) ")
    private String categoryTitle;
    @Size(min = 5, message = "Description must be greater than 5 characters. :) ")
    private String categoryDescription;
}