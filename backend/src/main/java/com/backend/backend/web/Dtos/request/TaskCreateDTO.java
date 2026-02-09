package com.backend.backend.web.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDTO {

    private String title;
    private String description;
    private String dueDate;
    private Long userId;
    
}
