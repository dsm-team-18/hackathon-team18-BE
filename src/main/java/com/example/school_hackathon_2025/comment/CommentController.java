package com.example.school_hackathon_2025.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/discussion/{discussion-id}/comments")
    public void createComment(@RequestBody @Valid CommentDto commentDto) {
        commentService.createComment(commentDto);
    }

    @GetMapping("/comments")
    public List<CommentResponse> findAll() {
        return commentService.findAll();
    }

    @PatchMapping("/comments/{comment-id}/like")
    public void likeComment(@PathVariable("comment-id") Long commentId) {
        commentService.likeComment(commentId);
    }
}