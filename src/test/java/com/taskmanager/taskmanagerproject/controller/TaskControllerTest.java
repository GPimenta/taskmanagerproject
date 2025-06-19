package com.taskmanager.taskmanagerproject.controller;

import com.taskmanager.taskmanagerproject.model.Task;
import com.taskmanager.taskmanagerproject.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
//@TestPropertySource("classpath:application-test.yaml")
public class TaskControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void sanityCheck() {
        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks).isNotEmpty();
        tasks.forEach(System.out::println);
    }

    @Test
    void getAllTasks() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/tasks", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        System.out.println("HERE");
        System.out.println(response);
    }
}
