package com.taskmanager.taskmanagerproject.controller;

import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.dto.TaskCreateRequest;
import com.taskmanager.taskmanagerproject.model.TaskListDetails;
import com.taskmanager.taskmanagerproject.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("v1/tasks")
public class TaskController implements ITaskController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public ResponseEntity<?> findAll(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "createdAt",
                    direction = Sort.Direction.ASC)
            Pageable pageable) {
        TaskListDetails allTasks = taskService.getAllTasks(pageable);

        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.getTask(id);

        try {
            if (optionalTask.isPresent()) {
                return ResponseEntity.ok(optionalTask.get());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Error getting task with id {}: {}", id, e.getMessage(), e);

            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskCreateRequest request, UriComponentsBuilder ucb) {
        Task task = taskService.createTask(request);

        Optional<Task> validateTask = taskService.getTask(task.getId());

        if (validateTask.isEmpty()) {
            return ResponseEntity.internalServerError().build();
        } else {
            URI uri = ucb.path("v1/tasks/{id}")
                    .buildAndExpand(validateTask.get().getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
    }
}
