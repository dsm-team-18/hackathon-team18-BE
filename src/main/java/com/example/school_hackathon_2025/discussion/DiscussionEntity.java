package com.example.school_hackathon_2025.discussion;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    public String tag;
}
