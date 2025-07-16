package com.example.school_hackathon_2025.comment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceDto {

    @NotNull
    public String name;

    @NotNull
    public String url;
}
