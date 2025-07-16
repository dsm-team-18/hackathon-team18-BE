package com.example.school_hackathon_2025.discussion;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public void createDiscussion(DiscussionDto dto) {
        DiscussionEntity entity =
                DiscussionEntity.builder()
                        .writer(dto.writer)
                        .title(dto.title)
                        .content(dto.content)
                        .category(dto.category)
                        .createdAt(LocalDate.now())
                        .build();

        discussionRepository.save(entity);
    }

    public List<DiscussionResponse> findAll() {
        return discussionRepository.findAll().stream().map(DiscussionResponse::of).toList();
    }

    public DiscussionResponse findDiscussion(Long discussionId) {

        DiscussionEntity discussion = discussionRepository.findDiscussionEntityById(discussionId);

        discussion.viewCount++;
        discussionRepository.save(discussion);

        return DiscussionResponse.of(discussion);
    }

    public void deleteDiscussion(Long discussionId) {
        discussionRepository.deleteById(discussionId);
    }

    public void voteDiscussion(Long discussionId, Boolean agree) {
        DiscussionEntity discussion = discussionRepository.findById(discussionId).orElseThrow();

        if (agree) {
            discussion.agreeCount++;
        } else {
            discussion.disagreeCount++;
        }

        discussionRepository.save(discussion);
    }
}
