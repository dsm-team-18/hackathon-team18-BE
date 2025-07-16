package com.example.school_hackathon_2025.discussion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public void createDiscussion (DiscussionDto dto) {
        DiscussionEntity entity =
                DiscussionEntity.builder()
                        .writer(dto.writer)
                        .title(dto.title)
                        .content(dto.content)
                        .tag(dto.category)
                        .createdAt(LocalDate.now())
                        .build();

        discussionRepository.save(entity);
    }
}
