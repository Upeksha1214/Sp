package com.example.newsWebsite.controller;

import com.example.newsWebsite.entitie.Category;
import com.example.newsWebsite.entitie.Comment;
import com.example.newsWebsite.entitie.News;
import com.example.newsWebsite.service.NewsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // allow React dev server
public class NewsController {
    private final NewsService service;
    public NewsController(NewsService service) { this.service = service; }

    @GetMapping("/categories")
    public List<Category> getCategories() { return service.getAllCategories(); }

    @GetMapping("/categories/{id}/news")
    public List<News> getNewsByCategory(@PathVariable Long id) { return service.getNewsByCategory(id); }

    @GetMapping("/news/{id}")
    public News getNews(@PathVariable Long id) {
        return service.getNews(id).orElseThrow(() -> new RuntimeException("News not found"));
    }

    @GetMapping("/news/{id}/comments")
    public List<Comment> getComments(@PathVariable Long id) {
        return service.getCommentsForNews(id);
    }

    @PostMapping("/news/{id}/comments")
    public Comment addComment(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String author = body.getOrDefault("author", "Anonymous");
        String text = body.get("text");
        if (text == null || text.isBlank()) throw new RuntimeException("Comment text required");
        return service.addComment(id, author, text);
    }
}

