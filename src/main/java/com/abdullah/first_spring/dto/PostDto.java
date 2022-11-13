package com.abdullah.first_spring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {
    // Dto = Data Transform Object
    private Long id;
    private String title, url, content, shortDesc;
    private LocalDateTime createdOn, updatedOn;
}
