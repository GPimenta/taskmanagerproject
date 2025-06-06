package com.taskmanager.taskmanagerproject.repository;

import com.taskmanager.taskmanagerproject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
