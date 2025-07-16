package com.example.school_hackathon_2025.comment;

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

    @OneToMany
    @JoinColumn
    public List<CommentReferenceEntity> references = new ArrayList<>();
}