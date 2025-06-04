package org.example.controller;

import org.aspectj.bridge.Message;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskControllerService {

    private TaskService service = new TaskService();

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task.getTitle() == null || task.getDescription() == null) {
            return ResponseEntity.status(400).body(new Task("",""));
        }else{
            Task saved = service.addTask(task);
            return ResponseEntity.status(201).body(saved);
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> createTask() {
        return ResponseEntity.status(200).body(service.getTasks());
    }
}
