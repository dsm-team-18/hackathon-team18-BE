package com.example.school_hackathon_2025.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class CommentResponse {

    public Long id;

    public String writer;

    public String content;

    public Long likeCount;

    public Agreement agree;

    public List<ReferenceResponse> references;
}
