package com.abdullah.first_spring.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    // Dto = Data Transform Object
    private Long id;
    @NotEmpty(message = "Enter a title for the post.")
    private String title;
    private String url;
    @NotEmpty(message = "Every post must have a content.")
    private String content;
    @NotEmpty(message = "Give a short description about this post.")
    private String shortDesc;
    private LocalDateTime createdOn, updatedOn;
}
