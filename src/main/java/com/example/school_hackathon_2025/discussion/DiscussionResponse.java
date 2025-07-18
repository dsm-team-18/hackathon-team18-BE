package com.example.school_hackathon_2025.discussion;

import com.example.school_hackathon_2025.comment.CommentResponse;
import com.example.school_hackathon_2025.comment.ReferenceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class DiscussionResponse {
    public Long id;
    public String writer;
    public String title;
    public String content;
    public String category;
    public Integer readCount;
    public Integer agreeCount;
    public Integer disagreeCount;
    public List<CommentResponse> comments;

    public static DiscussionResponse of(DiscussionEntity entity) {
        return DiscussionResponse.builder()
                .id(entity.id)
                .title(entity.title)
                .content(entity.content)
                .category(entity.category)
                .readCount(entity.viewCount)
                .agreeCount(entity.agreeCount)
                .disagreeCount(entity.disagreeCount)
                .comments(
                        entity.comments.stream().map(
                                commentEntity -> CommentResponse.builder()
                                        .id(commentEntity.id)
                                        .writer(commentEntity.writer)
                                        .content(commentEntity.content)
                                        .likeCount(commentEntity.likeCount)
                                        .agree(commentEntity.agree)
                                        .references(commentEntity.references.stream().map(
                                                commentReferenceEntity -> ReferenceResponse.builder()
                                                        .name(commentReferenceEntity.name)
                                                        .url(commentReferenceEntity.url)
                                                        .build()
                                        ).toList())
                                        .build()
                        ).toList()
                )
                .build();
    }
}
//안녕