package com.example.school_hackathon_2025.discussion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;

    @PostMapping
    public void CreateDiscussion(@RequestBody DiscussionDto dto) {
        discussionService.createDiscussion(dto);
    }

    @GetMapping("/list")
    public List<DiscussionResponse> findAll() {
        return discussionService.findAll();
    }

    @PatchMapping("/{discussionId}/vote")
    public void voteDiscussion(@PathVariable Long discussionId, @RequestParam Boolean agree) {
        discussionService.voteDiscussion(discussionId, agree);
    }

    @DeleteMapping("/{discussion-id}")
    public void deleteDiscussion(@PathVariable("discussion-id") Long discussionId) {
        discussionService.deleteDiscussion(discussionId);
    }

    @GetMapping("/{discussion-id}")
    public DiscussionResponse findDiscussion(@PathVariable("discussion-id") Long discussionId) {
        return discussionService.findDiscussion(discussionId);
    }
}
