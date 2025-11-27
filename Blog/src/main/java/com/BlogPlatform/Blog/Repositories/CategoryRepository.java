package com.BlogPlatform.Blog.Repositories;

import com.BlogPlatform.Blog.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
