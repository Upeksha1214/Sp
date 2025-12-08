package com.example.newsWebsite.service;


import com.example.newsWebsite.entitie.Category;
import com.example.newsWebsite.entitie.Comment;
import com.example.newsWebsite.entitie.News;
import com.example.newsWebsite.repositories.CategoryRepository;
import com.example.newsWebsite.repositories.CommentRepository;
import com.example.newsWebsite.repositories.NewsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private final NewsRepository newsRepo;
    private final CategoryRepository categoryRepo;
    private final CommentRepository commentRepo;

    public NewsService(NewsRepository newsRepo, CategoryRepository categoryRepo, CommentRepository commentRepo) {
        this.newsRepo = newsRepo;
        this.categoryRepo = categoryRepo;
        this.commentRepo = commentRepo;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public List<News> getNewsByCategory(Long categoryId) {
        return newsRepo.findDistinctByCategoriesId(categoryId);
    }

    public Optional<News> getNews(Long id) {
        return newsRepo.findById(id);
    }

    public List<Comment> getCommentsForNews(Long newsId) {
        return commentRepo.findByNewsIdOrderByPostedAtAsc(newsId);
    }

    public Comment addComment(Long newsId, String author, String text) {
        News news = newsRepo.findById(newsId).orElseThrow(() -> new RuntimeException("News not found"));
        Comment c = new Comment(news, author, text);
        return commentRepo.save(c);
    }
}

