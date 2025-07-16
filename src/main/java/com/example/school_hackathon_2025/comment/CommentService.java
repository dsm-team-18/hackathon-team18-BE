package com.example.school_hackathon_2025.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
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

    public List<CommentResponse> findAll() {
        List<CommentEntity> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> CommentResponse.builder()
                        .id(comment.id)
                        .writer(comment.writer)
                        .content(comment.content)
                        .likeCount(comment.likeCount)
                        .references(comment.references.stream().map(
                                reference -> ReferenceResponse.builder()
                                        .name(reference.name)
                                        .url(reference.url)
                                        .build()
                        ).toList())
                        .build())
                .toList();
    }

    public void likeComment(long commentId) {

        CommentEntity comment = commentRepository.findCommentById(commentId);

        comment.likeCount++;
        commentRepository.save(comment);

    }
}