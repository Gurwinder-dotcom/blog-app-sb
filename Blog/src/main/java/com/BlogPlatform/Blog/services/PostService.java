package com.BlogPlatform.Blog.services;

import com.BlogPlatform.Blog.Payloads.PostDto;
import com.BlogPlatform.Blog.Payloads.PostResponse;

import java.util.List;

public interface PostService {
    //    Create
    PostDto createPost(PostDto postDto, Long userId, Long categoryId);

    //    Update
    PostDto updatePost(Long postId, PostDto postDto);

    //    delete
    void deletePost(Long postId);

    //    get All Posts
    PostResponse getAllPost(Integer pageNumber , Integer pageSize );

    //    get Single Post
    PostDto getPostById(Long postId);

    //    get All post by Category
    List<PostDto> getPostsByCategory(Long categoryId);

    //    get All Post by User
    List<PostDto> getPostsByUser(Long userId);

    //    searchPosts
    List<PostDto> searchPosts(String keyword);
}
