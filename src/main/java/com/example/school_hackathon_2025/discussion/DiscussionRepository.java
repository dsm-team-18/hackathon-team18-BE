package com.example.school_hackathon_2025.discussion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscussionRepository extends JpaRepository<DiscussionEntity, Long> {

  DiscussionEntity findDiscussionEntityById(Long id);
}
