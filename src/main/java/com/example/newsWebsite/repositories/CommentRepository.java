package com.example.newsWebsite.repositories;

import com.example.newsWebsite.entitie.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByNewsIdOrderByPostedAtAsc(Long newsId);
}
