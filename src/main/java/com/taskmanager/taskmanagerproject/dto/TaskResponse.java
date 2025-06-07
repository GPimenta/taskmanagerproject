package com.taskmanager.taskmanagerproject.dto;

import lombok.Data;
import java.time.LocalDate;


// check if necessary
@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
}
