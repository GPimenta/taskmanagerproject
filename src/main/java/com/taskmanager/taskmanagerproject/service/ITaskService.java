package com.taskmanager.taskmanagerproject.service;

import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.model.TaskListDetails;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface ITaskService {

    TaskListDetails getAllTasks(Pageable pageable);
    Optional<Task> getTask(Long id);
    Task createTask(String title, String description, LocalDate dueDate);
    Task updateTask(Task updatedTask);
    boolean deleteTask(Long id);
}
