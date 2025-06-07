package com.taskmanager.taskmanagerproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskUpdateRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

}
