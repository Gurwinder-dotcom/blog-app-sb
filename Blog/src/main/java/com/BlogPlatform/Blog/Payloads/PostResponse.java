package com.BlogPlatform.Blog.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
    private List<PostDto> content;
    private int pageSize;
    private int pageNumber;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
