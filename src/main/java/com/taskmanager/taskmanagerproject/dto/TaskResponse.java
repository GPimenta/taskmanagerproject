package com.taskmanager.taskmanagerproject.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Objects;


// check if necessary
//@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;

    public TaskResponse() {
    }

    public TaskResponse(Long id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskResponse response = (TaskResponse) o;
        return Objects.equals(id, response.id) && Objects.equals(title, response.title) && Objects.equals(description, response.description) && Objects.equals(dueDate, response.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate);
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
