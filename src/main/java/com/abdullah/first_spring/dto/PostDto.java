package com.abdullah.first_spring.dto;

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
    private String title, url, content, shortDesc;
    private LocalDateTime createdOn, updatedOn;
}
