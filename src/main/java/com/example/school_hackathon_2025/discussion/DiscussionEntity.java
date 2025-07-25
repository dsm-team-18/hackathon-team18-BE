package com.example.school_hackathon_2025.discussion;

import com.example.school_hackathon_2025.comment.CommentEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class DiscussionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 20)
    public String writer;

    @Column(nullable = false, length = 100)
    public String title;

    @Column(length = 1000)
    public String content;

    @Column(nullable = false)
    public LocalDate createdAt;

    @Column(nullable = false)
    public String category;

    @Column(nullable = false)
    public Integer agreeCount = 0;

    @Column(nullable = false)
    public Integer disagreeCount = 0;

    @Column(nullable = false)
    public Integer viewCount = 0;

    @OneToMany(mappedBy = "discussion")
    public List<CommentEntity> comments = new ArrayList<>();

}
