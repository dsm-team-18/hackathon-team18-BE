package com.example.school_hackathon_2025.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(CommentDto commentDto) {
        CommentEntity comment =
                CommentEntity.builder()
                        .writer(commentDto.getWriter())
                        .content(commentDto.getContent())
                        .build();

        comment.references.addAll(
                commentDto.references.stream().map(
                        it -> CommentReferenceEntity.builder()
                                .comment(comment)
                                .name(it.name)
                                .url(it.url)
                                .build()
                ).toList()
        );

        commentRepository.save(comment);
    }

    public List<CommentEntity> findAll() {
        List<CommentEntity> comments = commentRepository.findAll();
        return comments;
    }
}