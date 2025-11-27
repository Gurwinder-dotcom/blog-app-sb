package com.BlogPlatform.Blog.services;

import com.BlogPlatform.Blog.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //    create
    CategoryDto createCategory(CategoryDto categoryDto);

    //    update
    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

    //    delete
    void deleteCategory(Long categoryId);

    //    getById
    CategoryDto getCategoryById(Long categoryId);

    //    getAll
    List<CategoryDto> getCategories();
}
