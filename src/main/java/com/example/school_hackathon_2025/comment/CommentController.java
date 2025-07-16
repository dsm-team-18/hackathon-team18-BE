package com.example.school_hackathon_2025.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody @Valid CommentDto commentDto) {
        commentService.createComment(commentDto);
    }

    @GetMapping
    public List<CommentEntity> findAll() {
        return commentService.findAll();
    }

    @PatchMapping("/{comment-id}")
    public void likeComment(@PathVariable("comment-id") Long commentId) {
        commentService.likeComment(commentId);
    }


}