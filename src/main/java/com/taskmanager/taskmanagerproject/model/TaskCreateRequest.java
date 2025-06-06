package com.taskmanager.taskmanagerproject.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskCreateRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
}
