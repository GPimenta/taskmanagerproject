package com.taskmanager.taskmanagerproject.service;

import com.taskmanager.taskmanagerproject.dto.TaskUpdateRequest;
import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.dto.TaskCreateRequest;
import com.taskmanager.taskmanagerproject.model.TaskListDetails;
import com.taskmanager.taskmanagerproject.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Task createTask(TaskCreateRequest request) {
        Task task = new Task(request.getTitle(), request.getDescription(), request.getDueDate());
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Task updateTask(TaskUpdateRequest updatedTask, Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        return optionalTask.map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.saveAndFlush(task);

                }).orElseThrow(() -> new EntityNotFoundException("Task not found with id " + id));
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            return true;
        }).orElse(false);
    }
}
