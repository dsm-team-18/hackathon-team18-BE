package com.example.school_hackathon_2025.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommentReferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    public String name;

    @Column(nullable = false, length = 1000)
    public String url;

    @ManyToOne
    @JoinColumn(nullable = false)
    public CommentEntity comment;
}
