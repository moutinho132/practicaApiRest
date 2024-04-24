package com.live.practicaapirest.controller;


import com.live.practicaapirest.model.TaskDto;
import com.live.practicaapirest.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TaskDto saveTask(@RequestBody TaskDto task) {
        return taskService.addTask(task);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TaskDto findTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskDto updateTask(@RequestBody TaskDto task) {
        return taskService.updateTask(task);
    }
}
