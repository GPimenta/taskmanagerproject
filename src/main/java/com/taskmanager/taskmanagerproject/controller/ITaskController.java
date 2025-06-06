package com.taskmanager.taskmanagerproject.controller;

import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.model.TaskListDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ITaskController {
    public ResponseEntity<?> findAll(Pageable pageable);
    public ResponseEntity<?> getTask(Long id);
    public ResponseEntity<?> createTask(Task task);

}
