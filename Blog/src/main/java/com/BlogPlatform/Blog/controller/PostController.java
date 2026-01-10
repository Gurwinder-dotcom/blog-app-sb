package com.BlogPlatform.Blog.controller;

import com.BlogPlatform.Blog.Entity.ApiResponse;
import com.BlogPlatform.Blog.Payloads.PostDto;
import com.BlogPlatform.Blog.Payloads.PostResponse;
import com.BlogPlatform.Blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    //    create a post
    @PostMapping("/users/{userId}/categories/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Long userId, @PathVariable Long categoryId) {
        return new ResponseEntity<>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
    }

    //    get By User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostsByUser(@PathVariable Long userId
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize
            , @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
            , @RequestParam(value = "sortDir", defaultValue = "acs", required = false) String sortDir) {
        return new ResponseEntity<>(postService.getPostsByUser(userId, pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    //    get By Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostsByCategory(@PathVariable Long categoryId
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize
            , @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
            , @RequestParam(value = "sortDir", defaultValue = "acs", required = false) String sortDir) {
        return ResponseEntity.ok(postService.getPostsByCategory(categoryId, pageNumber, pageSize, sortBy, sortDir));
    }

    //    get All
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
            ,@RequestParam(value = "sortDir",defaultValue = "acs",required = false) String sortDir
    ) {
        return new ResponseEntity<>(postService.getAllPost(pageNumber, pageSize, sortBy,sortDir), HttpStatus.OK);
    }

    //    get Post By I'd
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    //    delete post By I'd
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully", true), HttpStatus.OK);
    }

    //    update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.updatePost(postId, postDto), HttpStatus.OK);
    }
}

