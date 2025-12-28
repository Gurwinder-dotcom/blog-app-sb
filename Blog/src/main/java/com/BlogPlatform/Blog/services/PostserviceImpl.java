package com.BlogPlatform.Blog.services;

import com.BlogPlatform.Blog.Entity.Category;
import com.BlogPlatform.Blog.Entity.Post;
import com.BlogPlatform.Blog.Entity.User;
import com.BlogPlatform.Blog.ExceptionHandling.ResourceNotFoundException;
import com.BlogPlatform.Blog.Payloads.PostDto;
import com.BlogPlatform.Blog.Payloads.PostResponse;
import com.BlogPlatform.Blog.Repositories.CategoryRepository;
import com.BlogPlatform.Blog.Repositories.PostRepository;
import com.BlogPlatform.Blog.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostserviceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    //create
    @Override
    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "category_id", categoryId));
        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setCategory(category);
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    //updatePost
    @Override
    public PostDto updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId));
        post.setBody(postDto.getBody());
        post.setTitle(postDto.getTitle());
        post.setImageName(postDto.getImageName());
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    //    deletePost
    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId));
        postRepository.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> postPage = postRepository.findAll(pageable);
        List<Post> posts = postPage.getContent();
        List<PostDto> postDto = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDto);
        postResponse.setPageNumber(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalPages(postPage.getTotalPages());
        postResponse.setTotalElements(postPage.getTotalElements());
        postResponse.setLastPage(postPage.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post postById = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId));
        return modelMapper.map(postById, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        List<Post> post = postRepository.findByCategory(category);
        return post.stream().map((postDtoList) -> modelMapper.map(postDtoList, PostDto.class)).toList();

    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "userId", userId));
        List<Post> posts = postRepository.findByUser(user);
        return posts.stream().map((post) -> modelMapper.map(post, PostDto.class)).toList();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
