package com.example.school_hackathon_2025.comment;

import com.example.school_hackathon_2025.discussion.DiscussionEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 20)
    public String writer;

    @Column(nullable = false, length = 1000)
    public String content;

    @ManyToOne
    @JoinColumn(name = "discussion_id", nullable = false)
    public DiscussionEntity discussion;

    @OneToMany(mappedBy = "comment")
    public List<CommentReferenceEntity> references = new ArrayList<>();
}