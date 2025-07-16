package com.example.school_hackathon_2025.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class CommentResponse {

    public String writer;

    public String content;

    public Long likeCount;

    public List<ReferenceResponse> references;
}
