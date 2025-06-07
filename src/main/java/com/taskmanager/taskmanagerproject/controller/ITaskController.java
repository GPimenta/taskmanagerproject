package com.taskmanager.taskmanagerproject.controller;

import com.taskmanager.taskmanagerproject.dto.TaskCreateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface ITaskController {
    public ResponseEntity<?> findAll(Pageable pageable);
    public ResponseEntity<?> getTask(Long id);
    public ResponseEntity<?> createTask(TaskCreateRequest request,  UriComponentsBuilder ucb);

}
