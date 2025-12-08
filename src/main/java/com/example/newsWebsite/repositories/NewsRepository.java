package com.example.newsWebsite.repositories;

import com.example.newsWebsite.entitie.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findDistinctByCategoriesId(Long categoryId);
}

