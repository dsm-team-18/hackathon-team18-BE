package com.example.school_hackathon_2025.discussion;

import com.example.school_hackathon_2025.comment.CommentResponse;

import java.util.List;

public class DiscussionResponse {
    public String writer;
    public String title;
    public String content;
    public String category;
    public Long viewCount;
    public Long agreeCount;
    public Long disagreeCount;
    public Long voteTotalCount;
    public List<CommentResponse> comments;
}
