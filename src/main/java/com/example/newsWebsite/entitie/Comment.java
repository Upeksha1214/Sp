package com.example.newsWebsite.entitie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


}

