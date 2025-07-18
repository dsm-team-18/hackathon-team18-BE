package com.example.school_hackathon_2025.comment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    @NotNull
    public String name;

    @NotNull
    public String content;

    @NotNull
    public Agreement agree;

    @Valid
    public List<ReferenceDto> references;
}
