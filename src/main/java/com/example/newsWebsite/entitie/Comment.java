package com.example.newsWebsite.entitie;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "news_id")
    private News news;

    private String author;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime postedAt = LocalDateTime.now();

    public Comment() {}
    public Comment(News news, String author, String text) {
        this.news = news; this.author = author; this.text = text;
    }

    public Long getId() { return id; }
    public News getNews() { return news; }
    public String getAuthor() { return author; }
    public String getText() { return text; }
    public LocalDateTime getPostedAt() { return postedAt; }

    public void setNews(News news) { this.news = news; }
    public void setAuthor(String author) { this.author = author; }
    public void setText(String text) { this.text = text; }
}

