package com.taskmanager.taskmanagerproject.service;

import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.model.TaskListDetails;
import com.taskmanager.taskmanagerproject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskListDetails getAllTasks(Pageable pageable) {
        Page<Task> page = taskRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSort()
                )
        );

        String next = page.hasNext() ? "/v1/tasks?page=" + (page.getNumber() + 1) + "&size=" + page.getSize() : null;

        return new TaskListDetails(page.getContent(), page.getTotalElements(), next);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(String title, String description, LocalDate dueDate) {
        return null;
    }

    @Override
    public Task updateTask(Task updatedTask) {
        return null;
    }

    @Override
    public boolean deleteTask(Long id) {
        return false;
    }
}
