package com.example.newsWebsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record NewsHeadlineDTO(Long id, String title, String publishedAt) {}
