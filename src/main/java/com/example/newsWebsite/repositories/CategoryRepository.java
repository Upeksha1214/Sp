package com.example.newsWebsite.repositories;

import com.example.newsWebsite.entitie.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

