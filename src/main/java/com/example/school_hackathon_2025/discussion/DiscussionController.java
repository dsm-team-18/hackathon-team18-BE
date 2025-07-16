package com.example.school_hackathon_2025.discussion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    private final DiscussionService discussionService;

    @PostMapping
    public void CreateDiscussion(@RequestBody DiscussionDto dto) {
        discussionService.createDiscussion(dto);
    }

    @GetMapping
    public List<DiscussionEntity> findAll() {
       return discussionService.findAll();
    }
}







